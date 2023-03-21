package com.example.myapplication

class Classroom {
    var id : Int = 0
    private var roomNumber : String = ""
    private var location : String = ""
    //schedule
    //qrcode

    constructor(roomNumber : String = "", location : String = ""){
        this.roomNumber = roomNumber
        this.location = location
    }
}