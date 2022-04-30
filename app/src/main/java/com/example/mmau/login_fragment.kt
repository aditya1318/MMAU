package com.example.mmau
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class login_fragment : Fragment() {


    lateinit var lgnBtn : Button

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
        val view : View = inflater.inflate(R.layout.fragment_login_fragment, container, false)

        lgnBtn = view.findViewById(R.id.loginbtn)

        lgnBtn.setOnClickListener {

            findNavController().navigate(R.id.register_fragment)

        }





        return view
    }


}
