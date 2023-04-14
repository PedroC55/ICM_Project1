package com.example.myapplication.classes

import com.example.myapplication.R
import com.tomtom.sdk.location.GeoPoint
import com.tomtom.sdk.map.display.image.ImageFactory
import com.tomtom.sdk.map.display.marker.Marker
import com.tomtom.sdk.map.display.marker.MarkerOptions

class Markers {

    var allMarkers = mutableListOf<MarkerOptions>()

    val reitoria = MarkerOptions(
        coordinate = GeoPoint(40.63135360702917, -8.657449692844947),
        pinImage = ImageFactory.fromResource(R.drawable.uni)
    )

    val deti = MarkerOptions(
        coordinate = GeoPoint(40.63317591846193, -8.659494546730407),
        pinImage = ImageFactory.fromResource(R.drawable.uni)
    )

    val dbio = MarkerOptions(
        coordinate = GeoPoint(40.63380844264432, -8.659319462526593),
        pinImage = ImageFactory.fromResource(R.drawable.uni)
    )

    val psi = MarkerOptions(
        coordinate = GeoPoint(40.63182805953909, -8.658864860099207),
        pinImage = ImageFactory.fromResource(R.drawable.uni)
    )

    val degeit = MarkerOptions(
        coordinate = GeoPoint(40.630880306269695, -8.656999188889994),
        pinImage = ImageFactory.fromResource(R.drawable.uni)
    )

    val dmat = MarkerOptions(
        coordinate = GeoPoint(40.630418129607875, -8.658197920184241),
        pinImage = ImageFactory.fromResource(R.drawable.uni)
    )

    val essua = MarkerOptions(
        coordinate = GeoPoint(40.6235935159463, -8.657460978613498),
        pinImage = ImageFactory.fromResource(R.drawable.uni)
    )

    val casaEst = MarkerOptions(
        coordinate = GeoPoint(40.623866678205154, -8.657312103521186),
        pinImage = ImageFactory.fromResource(R.drawable.friends)
    )

    val cantinaCrasto = MarkerOptions(
        coordinate = GeoPoint(40.62447122149206, -8.656821947720015),
        pinImage = ImageFactory.fromResource(R.drawable.canteen)
    )

    val residenciaCrasto = MarkerOptions(
        coordinate = GeoPoint(40.62380984051734, -8.659262515140039),
        pinImage = ImageFactory.fromResource(R.drawable.house)
    )

    val residencia = MarkerOptions(
        coordinate = GeoPoint(40.63232334279521, -8.655852417698153),
        pinImage = ImageFactory.fromResource(R.drawable.house)
    )

    val restauranteUni = MarkerOptions(
        coordinate = GeoPoint(40.631258921278736, -8.65557516626951),
        pinImage = ImageFactory.fromResource(R.drawable.canteen)
    )


    val isca = MarkerOptions(
        coordinate = GeoPoint(40.63062465540277, -8.653337438511986),
        pinImage = ImageFactory.fromResource(R.drawable.uni)
    )

    val estga = MarkerOptions(
        coordinate = GeoPoint(40.57467735207429, -8.443419074739488),
        pinImage = ImageFactory.fromResource(R.drawable.uni)
    )

    val esan = MarkerOptions(
        coordinate = GeoPoint(40.8622535929045, -8.476219335824565),
        pinImage = ImageFactory.fromResource(R.drawable.uni)
    )

    val meca = MarkerOptions(
        coordinate = GeoPoint(40.630021263651315, -8.657528827736456),
        pinImage = ImageFactory.fromResource(R.drawable.uni)
    )

    val meialua = MarkerOptions(
        coordinate = GeoPoint(40.62956644327867, -8.656410184497393),
        pinImage = ImageFactory.fromResource(R.drawable.friends)
    )

    val civil = MarkerOptions(
        coordinate = GeoPoint(40.62978991586072, -8.657206782531778),
        pinImage = ImageFactory.fromResource(R.drawable.uni)
    )

    val artes = MarkerOptions(
        coordinate = GeoPoint(40.62899942110188, -8.65628433654733),
        pinImage = ImageFactory.fromResource(R.drawable.uni)
    )

    val cp = MarkerOptions(
        coordinate = GeoPoint(40.62934816993908, -8.655123620379278),
        pinImage = ImageFactory.fromResource(R.drawable.uni)
    )

    val cantina = MarkerOptions(
        coordinate = GeoPoint(40.630603650689594, -8.659099328532545),
        pinImage = ImageFactory.fromResource(R.drawable.canteen)
    )

    val fotossíntese = MarkerOptions(
        coordinate = GeoPoint(40.63146706467744, -8.658989206042046),
        pinImage = ImageFactory.fromResource(R.drawable.friends)
    )

    val pavilhão = MarkerOptions(
        coordinate = GeoPoint(40.62985965801426, -8.654152146349025),
        pinImage = ImageFactory.fromResource(R.drawable.sports)
    )




    fun getMarkers() : List<MarkerOptions>{
        allMarkers.add(pavilhão)
        allMarkers.add(fotossíntese)
        allMarkers.add(degeit)
        allMarkers.add(deti)
        allMarkers.add(cp)
        allMarkers.add(cantina)
        allMarkers.add(isca)
        allMarkers.add(psi)
        allMarkers.add(artes)
        allMarkers.add(civil)
        allMarkers.add(meca)
        allMarkers.add(reitoria)
        allMarkers.add(essua)
        allMarkers.add(estga)
        allMarkers.add(esan)
        allMarkers.add(dbio)
        allMarkers.add(dmat)
        allMarkers.add(casaEst)
        allMarkers.add(residencia)
        allMarkers.add(residenciaCrasto)
        allMarkers.add(restauranteUni)
        allMarkers.add(cantinaCrasto)
        allMarkers.add(meialua)
        return allMarkers
    }
}