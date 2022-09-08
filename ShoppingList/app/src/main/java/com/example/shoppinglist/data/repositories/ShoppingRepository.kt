package com.example.shoppinglist.data.repositories

import com.example.shoppinglist.data.dp.ShoppingDatabase
import com.example.shoppinglist.data.dp.entities.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun insertShoppingItem(item: ShoppingItem) = db.getShoppingDao().upsert(item)
    suspend fun deleteShoppingItem(item: ShoppingItem) = db.getShoppingDao().delete(item)
    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}