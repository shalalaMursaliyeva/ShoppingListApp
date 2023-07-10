package com.example.mvvmshoppinglist.repositories

import com.example.mvvmshoppinglist.db.ShoppingDatabase
import com.example.mvvmshoppinglist.db.entities.ShoppingItem

class ShoppingRepository(private val db: ShoppingDatabase) {


    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllItems() = db.getShoppingDao().getAllItems()
}