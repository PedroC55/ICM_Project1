package com.example.myapplication.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log
import android.widget.Toast
import com.example.myapplication.classes.Events
import com.example.myapplication.database.DatabaseInfo.TableEvents.COL_DESCRIPTION
import com.example.myapplication.database.DatabaseInfo.TableEvents.COL_HOURS
import com.example.myapplication.database.DatabaseInfo.TableEvents.COL_LOCATION
import com.example.myapplication.database.DatabaseInfo.TableEvents.COL_NAME
import com.example.myapplication.database.DatabaseInfo.TableEvents.COL_NUMBEROFPERSONS
import com.example.myapplication.database.DatabaseInfo.TableEvents.COL_TAG
import com.example.myapplication.database.DatabaseInfo.TableEvents.TABLE_NAME

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
                    TableEvents.COL_TAG + " TEXT)"

    val SQL_DELETE_TABLE_EVENTS_QUERY = "DROP TABLE IF EXISTS" + TableEvents.TABLE_NAME

    object TableEvents : BaseColumns {
        const val TABLE_NAME = "events"
        const val COL_NAME = "name"
        const val COL_LOCATION = "location"
        const val COL_HOURS = "hours"
        const val COL_NUMBEROFPERSONS = "numberOfPersons"
        const val COL_DESCRIPTION = "description"
        const val COL_TAG = "tag"
    }

    override fun onCreate(p0: SQLiteDatabase) {
        p0.execSQL(SQL_CREATE_TABLE_EVENTS_QUERY)
        Log.d("Created123", "DATABASE")
    }

    override fun onUpgrade(p0: SQLiteDatabase, p1: Int, p2: Int) {
        p0.execSQL("DROP TABLE IF EXISTS " + TableEvents.TABLE_NAME)
        onCreate(p0)
    }

    fun insertEventsData (event:Events){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME, event.name)
        cv.put(COL_LOCATION, event.location)
        cv.put(COL_HOURS, event.hours)
        cv.put(COL_NUMBEROFPERSONS, event.numberOfPersons)
        cv.put(COL_DESCRIPTION, event.description)
        cv.put(COL_TAG, event.tag)
        db.insert(TABLE_NAME, null, cv)
        db.close()
    }

    fun getName(): Cursor {

        // here we are creating a readable
        // variable of our database
        // as we want to read value from it
        val db = this.readableDatabase

        // below code returns a cursor to
        // read data from the database
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)

    }
}