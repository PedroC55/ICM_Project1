package com.example.myapplication.classes

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.database.DatabaseInfo
import com.tomtom.sdk.location.GeoPoint
import kotlin.properties.Delegates

class ScheduleAdapter: RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    var days = arrayListOf<String>("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
    var hours = arrayListOf<String>("08:00-10:00", "10:00-12:00", "12:00-14:00", "14:00-16:00", "16:00-18:00")
    var marks = mutableListOf<String>()

    var itemid: Int = 0
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var day: TextView
        var hour1: TextView
        var hour2: TextView
        var hour3: TextView
        var hour4: TextView
        var hour5: TextView
        var mark1: TextView
        var mark2: TextView
        var mark3: TextView
        var mark4: TextView
        var mark5: TextView

        init {
            day = itemView.findViewById(R.id.day)
            hour1 = itemView.findViewById(com.example.myapplication.R.id.hour1)
            hour2 = itemView.findViewById(com.example.myapplication.R.id.hour2)
            hour3 = itemView.findViewById(com.example.myapplication.R.id.hour3)
            hour4 = itemView.findViewById(com.example.myapplication.R.id.hour4)
            hour5 = itemView.findViewById(com.example.myapplication.R.id.hour5)
            mark1 = itemView.findViewById(com.example.myapplication.R.id.mark1)
            mark2 = itemView.findViewById(com.example.myapplication.R.id.mark2)
            mark3 = itemView.findViewById(com.example.myapplication.R.id.mark3)
            mark4 = itemView.findViewById(com.example.myapplication.R.id.mark4)
            mark5 = itemView.findViewById(com.example.myapplication.R.id.mark5)
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val db = DatabaseInfo(parent.context, null)
        var s = db.getSchedule(classroom)
        s.moveToFirst()
        marks.add(s.getString(3))
        while(s.moveToNext()){
            marks.add(s.getString(3))

        }
        Log.d("Marks:", marks.toString())


        val v = LayoutInflater.from(parent.context)
            .inflate(com.example.myapplication.R.layout.day_schedule, parent, false)
        return ViewHolder(v)
    }
    var classroom by Delegates.notNull<String>()
    fun sClassroom(s: String){
        classroom = s
    }


    override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {
        holder.day.text = days[position]
        holder.hour1.text = hours[0]
        holder.hour2.text = hours[1]
        holder.hour3.text = hours[2]
        holder.hour4.text = hours[3]
        holder.hour5.text = hours[4]
        var itemidDef = itemID()

        holder.mark1.text = marks[position+ (itemidDef*(itemCount-1))]

        holder.mark2.text = marks[position+1 + (itemidDef*(itemCount-1))]

        holder.mark3.text = marks[position+2 + (itemidDef*(itemCount-1))]

        holder.mark4.text = marks[position+3 + (itemidDef*(itemCount-1))]

        holder.mark5.text = marks[position+4 + (itemidDef*(itemCount-1))]

    }

    fun switchMarks(string:String , db: DatabaseInfo){
        id2 = -1
        marks.clear()
        var s = db.getSchedule(classroom)
        s.moveToFirst()
        marks.add(s.getString(3))
        while(s.moveToNext()){
            marks.add(s.getString(3))

        }

    }
    var id2 = -1
    fun itemID(): Int{
        id2 = id2 +1
        return id2
    }

    override fun getItemCount(): Int {
        return days.size
    }
}