package com.example.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.dp.entities.ShoppingItem
import com.example.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val respository: ShoppingRepository
):ViewModel() {
    fun insertShoppingItem(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        respository.insertShoppingItem(item)
    }
    fun deleteShoppingItem(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        respository.deleteShoppingItem(item)
    }
    fun getAllShoppingItems() = respository.getAllShoppingItems()
}