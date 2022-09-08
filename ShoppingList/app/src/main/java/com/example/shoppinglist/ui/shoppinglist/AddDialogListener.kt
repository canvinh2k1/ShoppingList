package com.example.shoppinglist.ui.shoppinglist

import com.example.shoppinglist.data.dp.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}