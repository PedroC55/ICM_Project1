package com.example.myapplication.classes

class Events {
    var id : Int = 0
    var name : String = ""
    private var location : String = ""
    private var hours : String = ""
    private var numberOfPersons : Int = 0
    private var description : String = ""
    private var tag : String = ""
    //photo

    constructor(name : String, location : String, hours : String, numberOfPersons : Int = 1, description : String, tag : String){
        this.name = name
        this.location = location
        this.hours = hours
        this.numberOfPersons = numberOfPersons
        this.description = description
        this.tag = tag
    }
}