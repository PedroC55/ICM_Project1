package com.example.myapplication.classes

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.database.DatabaseInfo
import kotlin.properties.Delegates

class StudentScheduleAdapter: RecyclerView.Adapter<StudentScheduleAdapter.ViewHolder>() {

    var days = arrayListOf<String>("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
    var hours = mutableListOf<String>()
    var marks = mutableListOf<String>()
    var numberClassesDay = mutableListOf<Int>()


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
            var markers = mutableListOf<TextView>(mark1, mark2, mark3, mark4, mark5)
            var hourers = mutableListOf<TextView>(hour1, hour2, hour3, hour4, hour5)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val db = DatabaseInfo(parent.context, null)
        var s = db.getStudentSchedule(student)
        s.moveToFirst()
        marks.add(s.getString(3))
        while(s.moveToNext()){
            marks.add(s.getString(3))

        }
        Log.d("Marks:", marks.toString())


        val v = LayoutInflater.from(parent.context)
            .inflate(com.example.myapplication.R.layout.student_schedule, parent, false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    var student by Delegates.notNull<Int>()
    fun sClassroom(s: Int){
        student = s
    }

}