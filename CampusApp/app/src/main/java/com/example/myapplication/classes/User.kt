package com.example.myapplication.classes

class User {
    var id : Int = 0
    var name : String = ""
    var age : Int = 0
    var email : String = ""
    var password : String = ""
    var nMec : Int = 0
    var phoneNumber : Int = 0
    var nif : Int = 0
    var nationality : String = ""
    //photo
    //schedule

    constructor(name:String, age:Int, email:String, password:String, nMec:Int, phoneNumber:Int, nif:Int, nationality:String){
        this.name = name
        this.age = age
        this.email = email
        this.password = password
        this.nMec = nMec
        this.phoneNumber = phoneNumber
        this.nif = nif
        this.nationality = nationality
    }
}