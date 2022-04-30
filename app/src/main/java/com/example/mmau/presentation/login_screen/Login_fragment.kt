package com.example.mmau.presentation.login_screen
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.mmau.R
import com.example.mmau.util.UserPreferences
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.InternalCoroutinesApi
import java.lang.Exception

import kotlinx.coroutines.flow.collect

class login_fragment : Fragment() {


    lateinit var lgnBtn : Button
    lateinit var username : EditText
    lateinit var  pass : EditText
    lateinit var  viewmodel : LoginScreenViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewmodel = activity?.let{
            ViewModelProvider(it).get(LoginScreenViewModel::class.java)
        }?: throw Exception("Activity is null")


    }

    @OptIn(InternalCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_login_fragment, container, false)
        var userPreference:UserPreferences = UserPreferences(requireContext())

        lgnBtn = view.findViewById(R.id.loginbtn)
        username = view.findViewById(R.id.username)
        pass = view.findViewById(R.id.password)

        lifecycleScope.launchWhenStarted {
          viewmodel.loginEventFlow.collect {event->
              when(event){
                  is LoginStateHandler.Success<*> -> {
                      userPreference.saveAuthToken(event.result.toString())
                        view.findNavController().navigate(R.id.home_nav_fragment)
                        Log.d("success","success is here")
                  }
                  is LoginStateHandler.Failure ->{
                      Snackbar.make(requireView(),event.errorText,Snackbar.LENGTH_LONG).show()
                  }
                  else -> Unit
              }
          }
          }


        lgnBtn.setOnClickListener {

            findNavController().navigate(R.id.register_fragment)

        }





        return view
    }


}

