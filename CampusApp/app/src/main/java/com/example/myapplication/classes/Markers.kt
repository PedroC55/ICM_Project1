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
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "Reitoria"
    )

    val deti = MarkerOptions(
        coordinate = GeoPoint(40.63317591846193, -8.659494546730407),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "DETI"
    )

    val dbio = MarkerOptions(
        coordinate = GeoPoint(40.63380844264432, -8.659319462526593),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "DBIO"
    )

    val psi = MarkerOptions(
        coordinate = GeoPoint(40.63182805953909, -8.658864860099207),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "DEP"
    )

    val degeit = MarkerOptions(
        coordinate = GeoPoint(40.630880306269695, -8.656999188889994),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "DEGEIT"
    )

    val dmat = MarkerOptions(
        coordinate = GeoPoint(40.630418129607875, -8.658197920184241),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "DMAT"
    )

    val essua = MarkerOptions(
        coordinate = GeoPoint(40.6235935159463, -8.657460978613498),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "Essua"
    )

    val casaEst = MarkerOptions(
        coordinate = GeoPoint(40.623866678205154, -8.657312103521186),
        pinImage = ImageFactory.fromResource(R.drawable.friends),
        tag = "Casa do Estudante/BE"
    )

    val cantinaCrasto = MarkerOptions(
        coordinate = GeoPoint(40.62447122149206, -8.656821947720015),
        pinImage = ImageFactory.fromResource(R.drawable.canteen),
        tag = "Cantina Crasto"
    )

    val residencia = MarkerOptions(
        coordinate = GeoPoint(40.63232334279521, -8.655852417698153),
        pinImage = ImageFactory.fromResource(R.drawable.house),
        tag = "Complexo Residencial"
    )

    val restauranteUni = MarkerOptions(
        coordinate = GeoPoint(40.631258921278736, -8.65557516626951),
        pinImage = ImageFactory.fromResource(R.drawable.canteen),
        tag = "Restaurante Universitário"
    )


    val isca = MarkerOptions(
        coordinate = GeoPoint(40.63062465540277, -8.653337438511986),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "ISCA"
    )

    val estga = MarkerOptions(
        coordinate = GeoPoint(40.57467735207429, -8.443419074739488),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "ESTGA"
    )

    val esan = MarkerOptions(
        coordinate = GeoPoint(40.8622535929045, -8.476219335824565),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "ESAN"
    )

    val meca = MarkerOptions(
        coordinate = GeoPoint(40.630021263651315, -8.657528827736456),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "DEM"
    )

    val meialua = MarkerOptions(
        coordinate = GeoPoint(40.62956644327867, -8.656410184497393),
        pinImage = ImageFactory.fromResource(R.drawable.friends),
        tag = "Meia Lua"
    )

    val civil = MarkerOptions(
        coordinate = GeoPoint(40.62978991586072, -8.657206782531778),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "DECivil"
    )

    val artes = MarkerOptions(
        coordinate = GeoPoint(40.62899942110188, -8.65628433654733),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "DeCA"
    )

    val cp = MarkerOptions(
        coordinate = GeoPoint(40.62934816993908, -8.655123620379278),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "Complexo Pedagógico"
    )

    val cantina = MarkerOptions(
        coordinate = GeoPoint(40.630603650689594, -8.659099328532545),
        pinImage = ImageFactory.fromResource(R.drawable.canteen),
        tag = "Cantina de Santiago"
    )

    val fotossíntese = MarkerOptions(
        coordinate = GeoPoint(40.63146706467744, -8.658989206042046),
        pinImage = ImageFactory.fromResource(R.drawable.friends),
        tag = "Fotossíntese"
    )

    val pavilhão = MarkerOptions(
        coordinate = GeoPoint(40.62985965801426, -8.654152146349025),
        pinImage = ImageFactory.fromResource(R.drawable.sports),
        tag = "Pavilhão Aristides Hall"
    )

    val linguas = MarkerOptions(
        coordinate = GeoPoint(40.63530943837447, -8.657699549544633),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "DLC"
    )

    val antrei = MarkerOptions(
        coordinate = GeoPoint(40.63485708694915, -8.657525510585096),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "CESAM"
    )

    val amb = MarkerOptions(
        coordinate = GeoPoint(40.632537172829814, -8.659154323844664),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "DAO"
    )

    val mat = MarkerOptions(
        coordinate = GeoPoint(40.634351912083034, -8.658738378468893),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "DEMaC"
    )

    val csoc = MarkerOptions(
        coordinate = GeoPoint(40.62994174144051, -8.65824984251955),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "DCSPT"
    )

    val fisica = MarkerOptions(
        coordinate = GeoPoint(40.63027458509032, -8.656960124641419),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "DFIS"
    )

    val quimica = MarkerOptions(
        coordinate = GeoPoint(40.63004248986769, -8.65587054457578),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "DQ"
    )

    val geociencias = MarkerOptions(
        coordinate = GeoPoint(40.62960429902085, -8.656971448564825),
        pinImage = ImageFactory.fromResource(R.drawable.uni),
        tag = "DGEO"
    )




    fun getActiveMarker(s: String): MarkerOptions{
        for (m in getMarkers()){
            if (m.tag == s){
                return m
            }
        }
        return error("Not Found")
    }

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
        allMarkers.add(restauranteUni)
        allMarkers.add(cantinaCrasto)
        allMarkers.add(meialua)
        allMarkers.add(linguas)
        allMarkers.add(antrei)
        allMarkers.add(amb)
        allMarkers.add(mat)
        allMarkers.add(csoc)
        allMarkers.add(fisica)
        allMarkers.add(quimica)
        allMarkers.add(geociencias)
        return allMarkers
    }
}