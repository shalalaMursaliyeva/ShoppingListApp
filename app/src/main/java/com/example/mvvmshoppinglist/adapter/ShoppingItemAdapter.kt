package com.example.mvvmshoppinglist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.ui.ShoppingViewModel

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ViewHolder>() {
    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item){
        var amount: TextView
        var name : TextView
        var ivDelete: ImageView
        var ivPlus: ImageView
        var ivMinus: ImageView

        init {
            amount = item.findViewById(R.id.tvAmount)
            name = item.findViewById(R.id.tvName)
            ivDelete = item.findViewById(R.id.ivDelete)
            ivMinus = item.findViewById(R.id.ivMinus)
            ivPlus = item.findViewById(R.id.ivPlus)

        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var currentItem = items[position]
        holder.name.text = currentItem.name
        holder.amount.text = "${currentItem.amount}"
        holder.ivDelete.setOnClickListener {
            viewModel.delete(currentItem)

        }

        holder.ivMinus.setOnClickListener {
            currentItem.amount--
            if (currentItem.amount>0){
                viewModel.upsert(currentItem)

            }

        }
        holder.ivPlus.setOnClickListener {
            currentItem.amount++
            viewModel.upsert(currentItem)

        }



    }


}
