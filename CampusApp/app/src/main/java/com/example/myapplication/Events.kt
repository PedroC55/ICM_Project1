package com.example.myapplication

class Events {
    var id : Int = 0
    var name : String = ""
    private var location : String = ""
    private var hours : String = ""
    private var numberOfPersons : Int = 0
    //photo

    constructor(name : String, location : String, hours : String, numberOfPersons : Int = 1){
        this.name = name
        this.location = location
        this.hours = hours
        this.numberOfPersons = numberOfPersons
    }

}