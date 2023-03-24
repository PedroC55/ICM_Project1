package com.example.myapplication.classes

class Classroom {
    var id : Int = 0
    private var roomNumber : String = ""
    private var location : String = ""
    //schedule
    //qrcode
    //cena de ler o textinho

    constructor(roomNumber : String = "", location : String = ""){
        this.roomNumber = roomNumber
        this.location = location
    }
}