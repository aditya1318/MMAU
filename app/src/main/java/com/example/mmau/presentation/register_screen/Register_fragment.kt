package com.example.mmau.presentation.register_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.mmau.R

class register_fragment : Fragment() {

    lateinit var  rgstbtn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_register_fragment, container, false)

        rgstbtn = view.findViewById(R.id.register_btn)
        rgstbtn.setOnClickListener {
            findNavController().navigate(R.id.home_nav_fragment)
        }


        return view
    }
}