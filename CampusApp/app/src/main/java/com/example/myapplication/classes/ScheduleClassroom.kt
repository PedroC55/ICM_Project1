package com.example.myapplication.classes

class ScheduleClassroom {
    var id : Int = 0
    var roomNumber : String = ""
    var hours : String = ""
    var marks : String = ""

    constructor(roomNumber : String = "", hours : String = "", marks : String = ""){
        this.roomNumber = roomNumber
        this.hours = hours
        this.marks = marks
    }
}