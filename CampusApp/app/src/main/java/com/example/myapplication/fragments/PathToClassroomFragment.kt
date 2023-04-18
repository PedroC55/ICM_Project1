package com.example.myapplication.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.tomtom.quantity.Distance
import com.tomtom.sdk.common.measures.UnitSystem
import com.tomtom.sdk.location.GeoLocation
import com.tomtom.sdk.location.GeoPoint
import com.tomtom.sdk.location.LocationProvider
import com.tomtom.sdk.location.OnLocationUpdateListener
import com.tomtom.sdk.location.android.AndroidLocationProvider
import com.tomtom.sdk.location.android.AndroidLocationProviderConfig
import com.tomtom.sdk.map.display.MapOptions
import com.tomtom.sdk.map.display.TomTomMap
import com.tomtom.sdk.map.display.camera.CameraOptions
import com.tomtom.sdk.map.display.common.WidthByZoom
import com.tomtom.sdk.map.display.location.LocationMarkerOptions
import com.tomtom.sdk.map.display.route.Instruction
import com.tomtom.sdk.map.display.route.Route
import com.tomtom.sdk.map.display.route.RouteOptions
import com.tomtom.sdk.map.display.ui.MapFragment
import com.tomtom.sdk.map.display.ui.MapReadyCallback
import com.tomtom.sdk.routing.onboard.client.protos.Directions
import com.tomtom.sdk.routing.online.OnlineRoutePlanner
import com.tomtom.sdk.routing.online.OnlineRoutePlanner.Companion.create
import com.tomtom.sdk.routing.options.Itinerary
import com.tomtom.sdk.routing.options.RoutePlanningOptions
import com.tomtom.sdk.routing.options.calculation.AlternativeRoutesOptions
import com.tomtom.sdk.routing.options.calculation.CostModel
import com.tomtom.sdk.routing.options.calculation.RouteType
import com.tomtom.sdk.vehicle.Vehicle
import kotlin.Result.*
import com.tomtom.sdk.common.Result
import com.tomtom.sdk.map.display.gesture.MapPanningListener
import com.tomtom.sdk.map.display.image.ImageFactory
import com.tomtom.sdk.map.display.internal.va
import com.tomtom.sdk.map.display.marker.MarkerOptions
import com.tomtom.sdk.routing.RoutePlanningCallback
import com.tomtom.sdk.routing.RoutePlanningResponse
import com.tomtom.sdk.routing.RoutingFailure
import com.example.myapplication.classes.Markers
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.tomtom.sdk.map.display.camera.CameraChangeListener
import com.tomtom.sdk.map.display.internal.da
import com.tomtom.sdk.map.display.marker.Marker
import com.tomtom.sdk.search.SearchCallback
import com.tomtom.sdk.search.SearchOptions
import com.tomtom.sdk.search.SearchResponse
import com.tomtom.sdk.search.common.error.SearchFailure
import com.tomtom.sdk.search.online.OnlineSearch
import kotlin.time.Duration.Companion.milliseconds

class PathToClassroomFragment : Fragment(R.layout.fragment_path_to_classroom) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_path_to_classroom, container, false)
        val searchApi = OnlineSearch.create(requireContext(), "RPY3qms2zgGKWhmYyymKuclugljTJHbF")
        var m = Markers()

        val permission = Manifest.permission.ACCESS_FINE_LOCATION
        if (ContextCompat.checkSelfPermission(requireContext(), permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(permission), 1)
        }
        else{

            val mapOptions = MapOptions(mapKey = "RPY3qms2zgGKWhmYyymKuclugljTJHbF")
            val mapFragment = MapFragment.newInstance(mapOptions)

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.map_container, mapFragment)
                .commit()
            val androidLocationProviderConfig = AndroidLocationProviderConfig(
                minTimeInterval = 250L.milliseconds,
                minDistance = Distance.meters(20.0)
            )
            val locationProvider: LocationProvider = AndroidLocationProvider(
                context = requireContext(),
                config = androidLocationProviderConfig
            )
            val locationMarkerOptions = LocationMarkerOptions(
                type = LocationMarkerOptions.Type.Chevron
            )
            val aveiro = GeoPoint(40.63141158565673, -8.657464251254854)
            val cameraOptions = CameraOptions(
                position = aveiro,
                zoom = 14.0
            )
            val onLocationUpdateListener =
                OnLocationUpdateListener { location: GeoLocation -> /* YOUR CODE GOES HERE */ }
            mapFragment.getMapAsync { tomtomMap: TomTomMap ->
                tomtomMap.isMarkersFadingEnabled = true
                tomtomMap.isMarkersShrinkingEnabled = true
                tomtomMap.markersFadingRange = IntRange(20, 50)
                tomtomMap.markersShrinkingRange = IntRange(20, 50)
                tomtomMap.addMapPanningListener(object : MapPanningListener {
                    override fun onMapPanningEnded() {

                    }

                    override fun onMapPanningOngoing() {
                    }

                    override fun onMapPanningStarted() {
                        if (cameraOptions.zoom!!>12){
                            for(a in m.getMarkers()){
                                tomtomMap.addMarker(a)
                            }
                        }
                    }
                })

                tomtomMap.addMarkerClickListener { marker: Marker ->
                    if (!marker.isSelected()) {
                        marker.select()
                        mapFragment.markerBalloonViewAdapter = CustomBalloonViewAdapter(context = requireContext())
                    }
                }
                tomtomMap.addMapLongClickListener{
                    for(m in tomtomMap.markers){
                        if(m.isSelected()){
                            m.deselect()
                        }
                    }
                    true
                }
                tomtomMap.setLocationProvider(locationProvider)
                locationProvider.enable()
                tomtomMap.enableLocationMarker(locationMarkerOptions)
                tomtomMap.moveCamera(cameraOptions)
                locationProvider.addOnLocationUpdateListener(onLocationUpdateListener)
                val lastLocation = locationProvider.lastKnownLocation
            }
            var button = view.findViewById<Button>(R.id.button2)
            button.setOnClickListener(){
                requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation).visibility = View.VISIBLE
                var dest : GeoPoint?=null
                var localToGo = view.findViewById<EditText>(R.id.textView8).text.toString()
                if (localToGo.length>1){
                    var dept = localToGo.split(".")[0]
                    when (dept){
                        "02" -> dest = m.linguas.coordinate
                        "03" -> dest = m.antrei.coordinate
                        "04" -> dest = m.deti.coordinate
                        "05" -> dest = m.psi.coordinate
                        "06" -> dest = m.cantina.coordinate
                        "07" -> dest = m.amb.coordinate
                        "08" -> dest = m.dbio.coordinate
                        "09" -> dest = m.mat.coordinate
                        "10" -> dest = m.degeit.coordinate
                        "11" -> dest = m.dmat.coordinate
                        "12" -> dest = m.csoc.coordinate
                        "13" -> dest = m.fisica.coordinate
                        "15" -> dest = m.quimica.coordinate
                        "16" -> dest = m.geociencias.coordinate
                        "17" -> dest = GeoPoint(40.63116544468107, -8.659630330862388)
                        "20" -> dest = m.estga.coordinate
                        "21" -> dest = m.artes.coordinate
                        "22" -> dest = m.meca.coordinate
                        "23" -> dest = m.cp.coordinate
                        "25" -> dest = m.reitoria.coordinate
                        "28" -> dest = m.civil.coordinate
                        "30" -> dest = m.essua.coordinate
                        "34" -> dest = m.esan.coordinate
                        "35" -> dest = m.isca.coordinate
                    }
                }else{
                    when (localToGo){
                        "B" -> dest = m.residencia.coordinate
                        "E" -> dest = m.pavilhão.coordinate
                        "F" -> dest = m.restauranteUni.coordinate
                        "M" -> dest = m.cantinaCrasto.coordinate
                        "N" -> dest = m.casaEst.coordinate
                    }
                }
                if(locationProvider.lastKnownLocation!=null){
                    mapFragment.getMapAsync(){
                        it.removeRoutes()
                        val routePlanner = OnlineRoutePlanner.create(requireContext(), "RPY3qms2zgGKWhmYyymKuclugljTJHbF")
                        val routePlanningOptions = RoutePlanningOptions(
                            itinerary = Itinerary(origin = locationProvider.lastKnownLocation!!.position, destination = dest!!),
                            costModel = CostModel(routeType = RouteType.Efficient),
                            vehicle = Vehicle.Pedestrian(),
                            alternativeRoutesOptions = AlternativeRoutesOptions(maxAlternatives = 2)
                        )
                        var list = mutableListOf<GeoPoint>()
                        it.setFrameRate(24)
                        routePlanner.planRoute(
                            routePlanningOptions,
                            object : RoutePlanningCallback {
                                override fun onSuccess(result: RoutePlanningResponse) {
                                    for (i in result.routes.get(0).routePoints){
                                        list.add(i.coordinate)

                                    }
                                    val routeOptions = RouteOptions(
                                        geometry = list,
                                        color = Color.BLUE,
                                        outlineWidth = 0.7,
                                        widths = listOf(WidthByZoom(5.0)),
                                        tag = "Extra information about the route",
                                        departureMarkerVisible = true,
                                        destinationMarkerVisible = true
                                    )
                                    val route = it.addRoute(routeOptions)
                                }
                                override fun onFailure(failure: RoutingFailure) {
                                }
                                override fun onRoutePlanned(route: com.tomtom.sdk.routing.route.Route) {
                                }
                            }
                        )
                    }
                }else{
                    Snackbar.make(
                        view.findViewById(R.id.myCoordinatorLayout),
                        "Can't find current location!",
                        Snackbar.LENGTH_SHORT
                    ).apply { anchorView = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation) }
                        .show()


                }


            }
        }
        return view
    }
}