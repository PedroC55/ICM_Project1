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
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
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
import com.tomtom.sdk.routing.RoutePlanningCallback
import com.tomtom.sdk.routing.RoutePlanningResponse
import com.tomtom.sdk.routing.RoutingFailure

import kotlin.time.Duration.Companion.milliseconds

class PathToClassroomFragment : Fragment(R.layout.fragment_path_to_classroom) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_path_to_classroom, container, false)
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

            val routePlanner = OnlineRoutePlanner.create(requireContext(), "RPY3qms2zgGKWhmYyymKuclugljTJHbF")

            val vagos = GeoPoint(40.55220362077403, -8.686078872375395)
            /*val routePlanningOptions = RoutePlanningOptions(
                itinerary = Itinerary(origin = aveiro, destination = vagos),
                costModel = CostModel(routeType = RouteType.Efficient),
                vehicle = Vehicle.Truck(),
                alternativeRoutesOptions = AlternativeRoutesOptions(maxAlternatives = 2)
            )
            val result = routePlanner.planRoute(routePlanningOptions)
            when (result) {
                is Result.Success -> result.value()
                is Result.Failure -> result.failure()
            }*/

            /*val routePlanningOptions = RoutePlanningOptions(
                itinerary = Itinerary(origin = aveiro, destination = vagos),
                costModel = CostModel(routeType = RouteType.Efficient),
                guidanceOptions = routeOptions,
                vehicle = Vehicle.Truck(),
                alternativeRoutesOptions = AlternativeRoutesOptions(maxAlternatives = 2)
            )
            routePlanner.planRoute(
                routePlanningOptions,
                object : RoutePlanningCallback {
                    override fun onSuccess(result: RoutePlanningResponse) {
                        *//* YOUR CODE GOES HERE *//*
                    }

                    override fun onFailure(failure: RoutingFailure) {
                        *//* YOUR CODE GOES HERE *//*
                    }

                    override fun onRoutePlanned(route: com.tomtom.sdk.routing.route.Route) {
                        *//* YOUR CODE GOES HERE *//*
                    }
                }
            )*/


            //val rb = result.value().routes[0]


            val routePlanningOptions = RoutePlanningOptions(
                itinerary = Itinerary(origin = aveiro, destination = vagos),
                costModel = CostModel(routeType = RouteType.Fast),
                vehicle = Vehicle.Truck(),
                alternativeRoutesOptions = AlternativeRoutesOptions(maxAlternatives = 2)
            )
            Log.d("Itenerary:" ,routePlanningOptions.itinerary.toString())

            //val rotas = routePlanningOptions.itinerary.waypoints.get(0)

            //Log.d("rota:" ,rotas.toString())


            /*val routeOptions = RouteOptions(
                geometry = listOf(
                    aveiro,
                    vagos
                ),
                color = Color.BLUE,
                outlineWidth = 3.0,
                widths = listOf(WidthByZoom(5.0)),
                progress = Distance.meters(1000.0),
                instructions = listOf(
                    Instruction(
                        routeOffset = Distance.meters(1000.0),
                        combineWithNext = false
                    ),
                    Instruction(
                        routeOffset = Distance.meters(2000.0),
                        combineWithNext = true
                    ),
                    Instruction(routeOffset = Distance.meters(3000.0))
                ),
                tag = "Extra information about the route",
                departureMarkerVisible = true,
                destinationMarkerVisible = true
            )*/




            var list = mutableListOf<GeoPoint>()

            val onLocationUpdateListener =
                OnLocationUpdateListener { location: GeoLocation -> /* YOUR CODE GOES HERE */ }
            mapFragment.getMapAsync { tomtomMap: TomTomMap ->
                tomtomMap.setFrameRate(24)
                //val mapLocationProvider = tomtomMap.getLocationProvider()
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
                                outlineWidth = 3.0,
                                widths = listOf(WidthByZoom(5.0)),
                                progress = Distance.meters(1000.0),
                                instructions = listOf(
                                    Instruction(
                                        routeOffset = Distance.meters(1000.0),
                                        combineWithNext = false
                                    ),
                                    Instruction(
                                        routeOffset = Distance.meters(2000.0),
                                        combineWithNext = true
                                    ),
                                    Instruction(routeOffset = Distance.meters(3000.0))
                                ),
                                tag = "Extra information about the route",
                                departureMarkerVisible = true,
                                destinationMarkerVisible = true
                            )
                            val route = tomtomMap.addRoute(routeOptions)
                        }

                        override fun onFailure(failure: RoutingFailure) {
                            /* YOUR CODE GOES HERE */
                        }

                        override fun onRoutePlanned(route: com.tomtom.sdk.routing.route.Route) {

                        }
                    }
                )

                tomtomMap.setLocationProvider(locationProvider)
                locationProvider.enable()
                tomtomMap.enableLocationMarker(locationMarkerOptions)
                tomtomMap.moveCamera(cameraOptions)
                locationProvider.addOnLocationUpdateListener(onLocationUpdateListener)
                val lastLocation = locationProvider.lastKnownLocation
        }


        }
        // Inflate the layout for this fragment




        return view
    }
}