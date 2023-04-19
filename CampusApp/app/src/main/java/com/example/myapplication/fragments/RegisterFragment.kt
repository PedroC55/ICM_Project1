package com.example.myapplication.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.classes.User
import com.example.myapplication.database.DatabaseInfo
import com.google.android.material.bottomnavigation.BottomNavigationView


class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        // Inflate the layout for this fragment
        requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation).visibility = View.GONE
        requireActivity().findViewById<RecyclerView>(R.id.recyclerView).visibility = View.GONE
        val a : EditText = view.findViewById(R.id.enterName)
        val b : EditText = view.findViewById(R.id.enterAge)
        val c : EditText = view.findViewById(R.id.enterEmail)
        val d : EditText = view.findViewById(R.id.enterPassword)
        val e : EditText = view.findViewById(R.id.enterNMec)
        val f : EditText = view.findViewById(R.id.enterPhoneNumber)
        val g : EditText = view.findViewById(R.id.enterNif)
        val h : EditText = view.findViewById(R.id.enterNationality)
        val btn : Button = view.findViewById(R.id.addUser)
        btn.setOnClickListener{
            if(checkData(a,b,c,d,e,f,g,h)==0){
                val db = DatabaseInfo(requireContext(),null)
                val name = a.text.toString()
                val age = b.text.toString().toInt()
                val email = c.text.toString()
                val password = d.text.toString()
                val nMec = e.text.toString().toInt()
                val phoneNumber = f.text.toString().toInt()
                val nif = g.text.toString().toInt()
                val nationality = h.text.toString()

                // calling method to add
                // user to our database
                val user = User(name, age, email, password, nMec, phoneNumber, nif, nationality)
                db.insertUsersData(user)
                db.close()
                view.findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        }

        return view
    }
    override fun onPause() {
        super.onPause()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation).visibility = View.VISIBLE
        requireActivity().findViewById<RecyclerView>(R.id.recyclerView).visibility = View.VISIBLE
    }

    private fun isEmpty(text: EditText): Boolean {
        val str: CharSequence = text.text.toString()
        return TextUtils.isEmpty(str)
    }

    private fun checkData(a:EditText, b:EditText, c:EditText, d:EditText, e:EditText, f:EditText, g:EditText, h:EditText): Int{
        var ret = 0
        if(isEmpty(a)){
            a.error = "please enter name!"
            ret += 1
        }
        if(isEmpty(b)){
            b.error = "please enter age!"
            ret += 1
        }
        if(isEmpty(c)){
            c.error = "please enter email!"
            ret += 1
        }
        if(isEmpty(d)){
            d.error = "please enter password!"
            ret += 1
        }
        if(isEmpty(e)){
            e.error = "please enter nMec!"
            ret += 1
        }
        if(isEmpty(f)){
            f.error = "please enter phone number!"
            ret += 1
        }
        if(isEmpty(g)){
            g.error = "please enter nif!"
            ret += 1
        }
        if(isEmpty(h)){
            h.error = "please enter nationality!"
            ret += 1
        }
        if(d.text.toString().length<8){
            d.error = "Password must have more than 8 characters"
            ret += 1
        }
        if("@ua.pt" !in c.text.toString()){
            c.error = "Email must be from ua organization"
            ret += 1
        }
        return ret
    }
}