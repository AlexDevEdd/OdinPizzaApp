package com.example.odinpizzaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "item"
class MainActivity : AppCompatActivity() {

    private lateinit var  bottomMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomMenu = findViewById(R.id.bottom_menu)

        bottomMenu.setOnItemSelectedListener{ item ->
            when(item.itemId){
                R.id.main_item->{
                    val mainFragment = MainFragment()
                    replaceFragment(mainFragment)
                }
                R.id.cabinet_item-> {
                    val cabinetFragment = CabinetFragment()
                    replaceFragment(cabinetFragment)
                }
                R.id.about_us_item-> {
                    val aboutFragment = AboutFragment()
                    replaceFragment(aboutFragment)
                }
            }
            true
        }

        bottomMenu.selectedItemId =
        savedInstanceState?.getInt(
                LAST_SELECTED_ITEM) ?: R.id.main_item

    }

    private  fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_SELECTED_ITEM, bottomMenu.selectedItemId)
        super.onSaveInstanceState(outState)
    }

}
