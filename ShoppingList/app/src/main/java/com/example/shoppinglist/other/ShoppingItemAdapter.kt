package com.example.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.dp.entities.ShoppingItem
import com.example.shoppinglist.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val tvName : TextView = itemView.findViewById(R.id.tvName)
        private val tvAmount : TextView = itemView.findViewById(R.id.tvAmount)
        private val ivDelete : ImageView = itemView.findViewById(R.id.ivDelete)
        private val ivMinus : ImageView = itemView.findViewById(R.id.ivMinus)
        private val ivPlus : ImageView = itemView.findViewById(R.id.ivPlus)

        fun bind(item: ShoppingItem) {
            tvName.text = item.name
            tvAmount.text = item.amount.toString()

            ivDelete.setOnClickListener {
                viewModel.deleteShoppingItem(item)
            }

            ivMinus.setOnClickListener {
                item.amount--
                viewModel.insertShoppingItem(item)
            }

            ivPlus.setOnClickListener {
                if (item.amount > 0) {
                    item.amount++
                    viewModel.insertShoppingItem(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]
        holder.bind(currentShoppingItem)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}