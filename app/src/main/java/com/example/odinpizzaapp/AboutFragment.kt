package com.example.odinpizzaapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class AboutFragment : Fragment() {

    private lateinit var  backButton: Button
    private lateinit var  shareButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_about, container, false)

        val mainFragment = MainFragment()
        backButton = view.findViewById(R.id.back_button_about)
        backButton.setOnClickListener{
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragment_container, mainFragment)
                ?.commit()
        }
        shareButton = view.findViewById(R.id.share_button)
        val chooserIntent = Intent(Intent.ACTION_SEND)
        chooserIntent.type = "text/plain"
        chooserIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.company_email_value))
        val chooser = Intent.createChooser(chooserIntent, "Share")
        shareButton.setOnClickListener {
            startActivity(chooser)
        }

        return view
    }


}