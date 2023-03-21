package com.example.myapplication

class User {
    var id : Int = 0
    var name : String = ""
    private var age : Int = 0
    private var email : String = ""
    private var password : String = ""
    private var nMec : Int = 0
    private var phoneNumber : Int = 0
    private var nif : Int = 0
    private var nationality : String = ""
    //photo
    //schedule

    constructor(id:Int, name:String, age:Int, email:String, password:String, nMec:Int, phoneNumber:Int, nif:Int, nationality:String){
        this.id = id
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