package com.example.myapplication

class ScheduleStudent {
    private var studentNMec : Int = 0
    private var hours : String = ""
    private var marks : String = ""

    constructor(studentNMec : Int, hours : String, marks : String){
        this.studentNMec = studentNMec
        this.hours = hours
        this.marks = marks
    }
}