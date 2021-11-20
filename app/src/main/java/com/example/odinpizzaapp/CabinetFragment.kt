package com.example.odinpizzaapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class CabinetFragment : Fragment() {

    private lateinit var  backButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_cabinet, container, false)

        val mainFragment = MainFragment()
        backButton = view.findViewById(R.id.back_button_cabinet)
        backButton.setOnClickListener{
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragment_container, mainFragment)
                ?.commit()
        }

        return view
    }

}