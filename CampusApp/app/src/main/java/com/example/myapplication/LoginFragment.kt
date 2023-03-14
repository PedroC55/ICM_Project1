package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil.setContentView

import com.example.myapplication.databinding.ActivityMainBinding

import androidx.navigation.findNavController


class LoginFragment : Fragment(R.layout.login) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.login, container, false)
        val button: Button = view.findViewById(R.id.button_login)
        button.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)}
        return view
    }

}