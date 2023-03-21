package com.example.myapplication.classes

import android.provider.ContactsContract.Contacts.Photo

class Photos {
    var id : Int = 0
    private var studentOrEvent : Int = 0
    private var photo : Photo

    constructor(studentOrEvent : Int, photo : Photo){
        this.studentOrEvent = studentOrEvent
        this.photo = photo
    }
}