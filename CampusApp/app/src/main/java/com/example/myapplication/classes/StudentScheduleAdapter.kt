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
    var marks =  ArrayList<ArrayList<String>>()
    var hoursList = ArrayList<ArrayList<String>>()
    var classroom =  ArrayList<ArrayList<String>>()
    var itemid: Int = 0
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var day: TextView
        var hour1: TextView
        var mark1: TextView
        var classroom1 : TextView


        init {
            day = itemView.findViewById(R.id.day)
            hour1 = itemView.findViewById(com.example.myapplication.R.id.hour1)
            mark1 = itemView.findViewById(com.example.myapplication.R.id.mark1)
            classroom1 = itemView.findViewById(R.id.classroom1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val db = DatabaseInfo(parent.context, null)
        var s = db.getStudentSchedule(student)
        if(s.count>0){
            s.moveToFirst()
            var m = ArrayList<String>()
            var h = ArrayList<String>()
            var c = ArrayList<String>()
            var dia = s.getString(2).split("|")[0]
            m.add(s.getString(3))
            h.add(s.getString(2).split("|")[1])
            c.add(s.getString(2).split("|")[2])
            while(s.moveToNext()){
                if(dia == s.getString(2).split("|")[0]){
                    m.add(s.getString(3))
                    h.add(s.getString(2).split("|")[1])
                    c.add(s.getString(2).split("|")[2])
                }
                else{
                    marks.add(m)
                    hoursList.add(h)
                    classroom.add(c)
                    dia = s.getString(2).split("|")[0]
                    m = ArrayList<String>()
                    h = ArrayList<String>()
                    c = ArrayList<String>()
                    m.add(s.getString(3))
                    h.add(s.getString(2).split("|")[1])
                    c.add(s.getString(2).split("|")[2])
                }

            }
            marks.add(m)
            hoursList.add(h)
            classroom.add(c)
        }
        else{
            itemid=-1
        }

        val v = LayoutInflater.from(parent.context)
            .inflate(com.example.myapplication.R.layout.student_schedule, parent, false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(itemid<=9 && itemid != -1){
            holder.day.text = days[position]
            var hoursDisplay = ""
            for (h in hoursList[position]){
                itemid+=1
                hoursDisplay = hoursDisplay + h + "\n\n"
            }
            holder.hour1.text = hoursDisplay

            var marksDisplay = ""
            for (h in marks[position]){
                marksDisplay = marksDisplay + h + "\n\n"
            }
            holder.mark1.text = marksDisplay

            var classroomDisplay = ""
            for (h in classroom[position]){
                classroomDisplay = classroomDisplay + h + "\n\n"
            }
            holder.classroom1.text = classroomDisplay
        }else{
            holder.day.visibility = View.GONE
            holder.mark1.visibility = View.GONE
            holder.hour1.visibility = View.GONE
            holder.classroom1.visibility = View.GONE
            itemid=0
        }
    }


    var student by Delegates.notNull<Int>()
    fun sClassroom(s: Int){
        student = s
    }

}