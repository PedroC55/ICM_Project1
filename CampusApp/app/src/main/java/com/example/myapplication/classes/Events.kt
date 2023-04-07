package com.example.myapplication.classes

class Events {
    var id : Int = 0
    var name : String = ""
    var location : String = ""
    var hours : String = ""
    var numberOfPersons : Int = 0
    var description : String = ""
    var tag : String = ""
    var createdBy : Int = 0
    //photo

    constructor(name : String, location : String, hours : String, numberOfPersons : Int = 1, description : String, tag : String, createdBy : Int = 1){
        this.name = name
        this.location = location
        this.hours = hours
        this.numberOfPersons = numberOfPersons
        this.description = description
        this.tag = tag
        this.createdBy = createdBy
    }
}