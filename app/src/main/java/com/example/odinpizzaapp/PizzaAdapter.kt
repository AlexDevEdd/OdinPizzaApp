package com.example.odinpizzaapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class PizzaAdapter (private val pizzaList : ArrayList<Pizza>) :
    RecyclerView.Adapter<PizzaAdapter.PizzaHolder>() {

    private lateinit var mListener: onItemClickListener

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PizzaHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.pizza_list_item, viewGroup, false)
        return PizzaHolder(v, mListener)
    }

    override fun onBindViewHolder(holder: PizzaHolder, position: Int) {
        val currentItem = pizzaList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.heading.text = currentItem.pizzaName
        holder.price.text = currentItem.price
    }

    override fun getItemCount(): Int {
        return pizzaList.size
    }

        interface onItemClickListener {
            fun onItemClick(position: Int)
        }

        fun setOnItemClickListener(listener: onItemClickListener) {
            mListener = listener
        }

    class PizzaHolder(itemView : View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {

        val titleImage: ShapeableImageView = itemView.findViewById(R.id.title_image)
        val heading: TextView = itemView.findViewById(R.id.pizza_name)
        val price: TextView = itemView.findViewById(R.id.price)

        init {
            itemView.setOnClickListener() {
                 listener.onItemClick(adapterPosition)
            }
        }
    }
}
