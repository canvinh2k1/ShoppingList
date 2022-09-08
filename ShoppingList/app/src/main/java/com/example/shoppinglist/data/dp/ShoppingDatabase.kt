package com.example.shoppinglist.data.dp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppinglist.data.dp.entities.ShoppingItem


@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDatabase: RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao // dao bao rang co the truy cap vao shoppingdao

    companion object {

        @Volatile  // Dam bao rang chi co 1 thread va tao ra mot instance truy cap vao
        private var instance: ShoppingDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }
        // operator het hop voi invoke de dam bao rang ham nay luon duoc chay khi dc goi den

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ShoppingDatabase::class.java, "ShoppingDb.dh").build()
    }
}