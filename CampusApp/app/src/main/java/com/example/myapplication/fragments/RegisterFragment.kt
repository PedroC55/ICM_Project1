package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.R
import com.example.myapplication.classes.User
import com.example.myapplication.database.DatabaseInfo


class RegisterFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*arguments?.let {

        }*/


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        // Inflate the layout for this fragment
        val btn : Button = view.findViewById(R.id.addUser)
        btn.setOnClickListener{
            val db = DatabaseInfo(requireContext(),null)

            // creating variables for values
            // in name and age edit texts
            val a : EditText = view.findViewById(R.id.enterName)
            val b : EditText = view.findViewById(R.id.enterAge)
            val c : EditText = view.findViewById(R.id.enterEmail)
            val d : EditText = view.findViewById(R.id.enterPassword)
            val e : EditText = view.findViewById(R.id.enterNMec)
            val f : EditText = view.findViewById(R.id.enterPhoneNumber)
            val g : EditText = view.findViewById(R.id.enterNif)
            val h : EditText = view.findViewById(R.id.enterNationality)

            val name = a.text.toString()
            val age = b.text.toString().toInt()
            val email = c.text.toString()
            if(!email.contains("@ua.pt")){
                //ERROR
            }
            val password = d.text.toString()
            val nMec = e.text.toString().toInt()
            val phoneNumber = f.text.toString().toInt()
            val nif = g.text.toString().toInt()
            val nationality = h.text.toString()
            // calling method to add
            // name to our database
            val user : User = User(name, age, email, password, nMec, phoneNumber, nif, nationality)
            db.insertUsersData(user)
        }
        return view
    }


}