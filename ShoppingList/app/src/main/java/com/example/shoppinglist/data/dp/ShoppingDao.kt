package com.example.shoppinglist.data.dp

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppinglist.data.dp.entities.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)  // tranh add lai mot item da co
    suspend fun upsert(item: ShoppingItem)
    @Delete
    suspend fun delete(item: ShoppingItem)
    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>> // Livedata de dam bao rang du lieu dc cap nhat lien tuc
}