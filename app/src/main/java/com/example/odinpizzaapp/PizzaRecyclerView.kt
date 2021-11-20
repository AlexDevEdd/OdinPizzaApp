package com.example.odinpizzaapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class PizzaRecyclerView : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Pizza>
    /*  private var layoutManager: RecyclerView.LayoutManager? = null
      private var adapter: RecyclerView.Adapter<PizzaAdapter.PizzaHolder>? = null*/

    lateinit var imageId: Array<Int>
    lateinit var pizzaName: Array<String>
    lateinit var price: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_recycler_view)

        imageId = arrayOf(
            R.drawable.proshuto,
            R.drawable.margarita,
            R.drawable.felichita
        )
        pizzaName = arrayOf(
            "Прошуто-фунги",
            "Маргарита",
            "Феличита"
        )
        price = arrayOf(
            "400 рублей",
            "200 рублей",
            "600 рублей"
        )
        newRecyclerView = findViewById(R.id.pizza_recycle_view)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<Pizza>()
        getUserdata()
    }

    private fun getUserdata() {

        for (i in imageId.indices) {
            val pizza = Pizza(imageId[i], pizzaName[i], price[i])
            newArrayList.add(pizza).toString()

        }
        val adapter = PizzaAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : PizzaAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@PizzaRecyclerView , "${pizzaName[position]} " +
                        "\n ${price[position]}",
                    Toast.LENGTH_SHORT).show()
            }

        } )
    }
}