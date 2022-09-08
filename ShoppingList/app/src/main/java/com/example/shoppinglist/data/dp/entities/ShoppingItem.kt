package com.example.shoppinglist.data.dp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_amount")
    var amount: Int,
    @PrimaryKey(autoGenerate = true) val id: Int? = null // phai co id de xac dinh tung item khac biet voi cac item khac
)
