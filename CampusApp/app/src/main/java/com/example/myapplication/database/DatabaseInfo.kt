package com.example.myapplication.database

import android.R.id
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.example.myapplication.classes.Events
import com.example.myapplication.classes.User
import kotlin.properties.Delegates


class DatabaseInfo(context: Context, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper (context, DATABASE_NAME, factory, 2){
    companion object{
        val DATABASE_NAME = "campusappDB"
    }
    val SQL_CREATE_TABLE_EVENTS_QUERY =
            "CREATE TABLE " + TableEvents.TABLE_NAME + " (" +
            BaseColumns._ID + " INTEGER PRIMARY KEY, " +
                    TableEvents.COL_NAME + " TEXT, " +
                    TableEvents.COL_LOCATION + " TEXT, " +
                    TableEvents.COL_HOURS + " TEXT, " +
                    TableEvents.COL_NUMBEROFPERSONS + " INTEGER, " +
                    TableEvents.COL_DESCRIPTION + " TEXT, " +
                    TableEvents.COL_TAG + " TEXT, " +
                    TableEvents.COL_Creator + " INTEGER)"

    val SQL_DELETE_TABLE_EVENTS_QUERY = "DROP TABLE IF EXISTS" + TableEvents.TABLE_NAME

    val SQL_CREATE_TABLE_USERS_QUERY =
        "CREATE TABLE " + TableUser.TABLE_NAME + " (" +
                BaseColumns._ID + " INTEGER PRIMARY KEY, " +
                TableUser.COL_NAME + " TEXT, " +
                TableUser.COL_AGE + " INTEGER, " +
                TableUser.COL_EMAIL + " TEXT, " +
                TableUser.COL_PASSWORD + " TEXT, " +
                TableUser.COL_NMEC + " INTEGER, " +
                TableUser.COL_PHONENUMBER + " INTEGER, " +
                TableUser.COL_NIF + " INTEGER, " +
                TableUser.COL_NATIONALITY + " TEXT)"

    val SQL_CREATE_TABLE_CLASSROOM_QUERY =
        "CREATE TABLE " + TableClassroom.TABLE_NAME + " (" +
                BaseColumns._ID + " INTEGER PRIMARY KEY, " +
                TableClassroom.COL_ROOMNUMBER + " TEXT, " +
                TableClassroom.COL_LOCATION + " TEXT)"

    val SQL_CREATE_TABLE_CSCHEDULE_QUERY =
        "CREATE TABLE " + TableCSchedule.TABLE_NAME + " (" +
                BaseColumns._ID + " INTEGER PRIMARY KEY, " +
                TableCSchedule.COL_ROOMNUMBER + " TEXT, " +
                TableCSchedule.COL_HOURS + " TEXT, " +
                TableCSchedule.COL_MARKS + " TEXT)"


    val SQL_CREATE_TABLE_SSCHEDULE_QUERY =
        "CREATE TABLE " + TableSSchedule.TABLE_NAME + " (" +
                BaseColumns._ID + " INTEGER PRIMARY KEY, " +
                TableSSchedule.COL_STUDENTNMEC + " INTEGER, " +
                TableSSchedule.COL_HOURS + " TEXT, " +
                TableSSchedule.COL_MARKS + " TEXT)"

    val SQL_CREATE_TABLE_FRIENDS_QUERY =
        "CREATE TABLE " + TableFriends.TABLE_NAME + " (" +
                BaseColumns._ID + " INTEGER PRIMARY KEY, " +
                TableFriends.COL_F1 + " INTEGER, " +
                TableFriends.COL_F2 + " INTEGER)"

/*    val SQL_CREATE_TABLE_PHOTOS_QUERY =
        "CREATE TABLE " + TablePhotos.TABLE_NAME + " (" +
                BaseColumns._ID + " INTEGER PRIMARY KEY, " +
                TablePhotos.COL_STUEVE + " INTEGER, " +
                TablePhotos.COL_PHOTO + " TEXT)"*/

    object TableEvents : BaseColumns {
        const val TABLE_NAME = "events"
        const val COL_NAME = "name"
        const val COL_LOCATION = "location"
        const val COL_HOURS = "hours"
        const val COL_NUMBEROFPERSONS = "numberOfPersons"
        const val COL_DESCRIPTION = "description"
        const val COL_TAG = "tag"
        const val COL_Creator = "createdBy"
    }

    object TableUser : BaseColumns {
        const val TABLE_NAME = "users"
        const val COL_NAME = "name"
        const val COL_AGE = "age"
        const val COL_EMAIL = "email"
        const val COL_PASSWORD = "password"
        const val COL_NMEC = "nMec"
        const val COL_PHONENUMBER = "phoneNumber"
        const val COL_NIF = "nif"
        const val COL_NATIONALITY = "nationality"
    }

    object TableClassroom : BaseColumns {
        const val TABLE_NAME = "classrooms"
        const val COL_ROOMNUMBER = "roomNumber"
        const val COL_LOCATION = "location"
    }

    object TableCSchedule : BaseColumns {
        const val TABLE_NAME = "cSchedule"
        const val COL_ROOMNUMBER = "roomNumber"
        const val COL_HOURS = "hours"
        const val COL_MARKS = "marks"
    }

    object TableSSchedule : BaseColumns {
        const val TABLE_NAME = "sSchedule"
        const val COL_STUDENTNMEC = "studentNMec"
        const val COL_HOURS = "hours"
        const val COL_MARKS = "marks"
    }

    object TableFriends : BaseColumns {
        const val TABLE_NAME = "friends"
        const val COL_F1 = "stu1NMec"
        const val COL_F2 = "stu2NMec"
    }
    object TablePhotos : BaseColumns {
        const val TABLE_NAME = "photos"
        const val COL_STUEVE = "studentOrEvent"
        const val COL_PHOTO = "photo"
    }
    override fun onCreate(p0: SQLiteDatabase) {
        p0.execSQL(SQL_CREATE_TABLE_EVENTS_QUERY)
        p0.execSQL(SQL_CREATE_TABLE_USERS_QUERY)
        p0.execSQL(SQL_CREATE_TABLE_CLASSROOM_QUERY)
        p0.execSQL(SQL_CREATE_TABLE_CSCHEDULE_QUERY)
        p0.execSQL(SQL_CREATE_TABLE_SSCHEDULE_QUERY)
        p0.execSQL(SQL_CREATE_TABLE_FRIENDS_QUERY)
    }

    override fun onUpgrade(p0: SQLiteDatabase, p1: Int, p2: Int) {
        p0.execSQL("DROP TABLE IF EXISTS " + TableEvents.TABLE_NAME)
        onCreate(p0)
    }

    fun insertUsersData (user: User){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(TableUser.COL_NAME, user.name)
        cv.put(TableUser.COL_AGE, user.age)
        cv.put(TableUser.COL_EMAIL, user.email)
        cv.put(TableUser.COL_PASSWORD, user.password)
        cv.put(TableUser.COL_NMEC, user.nMec)
        cv.put(TableUser.COL_PHONENUMBER, user.phoneNumber)
        cv.put(TableUser.COL_NIF, user.nif)
        cv.put(TableUser.COL_NATIONALITY, user.nationality)
        db.insert(TableUser.TABLE_NAME, null, cv)
        db.close()
    }

    fun insertEventsData (event:Events){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(TableEvents.COL_NAME, event.name)
        cv.put(TableEvents.COL_LOCATION, event.location)
        cv.put(TableEvents.COL_HOURS, event.hours)
        cv.put(TableEvents.COL_NUMBEROFPERSONS, event.numberOfPersons)
        cv.put(TableEvents.COL_DESCRIPTION, event.description)
        cv.put(TableEvents.COL_TAG, event.tag)
        cv.put(TableEvents.COL_Creator, event.createdBy)
        db.insert(TableEvents.TABLE_NAME, null, cv)
        db.close()
    }

    fun getUserByEmail(email: String):Cursor{
        val db = this.readableDatabase
        val user = db.rawQuery("SELECT * FROM users WHERE email='$email';", null)

        return user
    }

    fun getUserById (id : Int) : Cursor{
        val db = this.readableDatabase
        val user = db.rawQuery("SELECT * FROM users WHERE _id='$id';", null)

        return user
    }
    fun getEvents():Cursor{
        val db = this.readableDatabase
        val events = db.rawQuery("SELECT * FROM events", null)
        return events

    }

    fun getEventById(id : Int):Cursor{
        val db = this.readableDatabase
        val event = db.rawQuery("SELECT * FROM events WHERE _id=$id;", null)
        return event
    }


/*    fun getName(): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)

    }*/
}