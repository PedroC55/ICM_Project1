package com.example.myapplication

import android.provider.ContactsContract.Contacts.Photo

class Photos {
    var id : Int = 0
    var studentOrEvent : Int = 0
    lateinit var photo : Photo

    constructor(studentOrEvent : Int, photo : Photo){
        this.studentOrEvent = studentOrEvent
        this.photo = photo
    }
}