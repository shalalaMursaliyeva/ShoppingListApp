package com.example.mvvmshoppinglist.ui

import androidx.lifecycle.ViewModel
import com.example.mvvmshoppinglist.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository):ViewModel() {
    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch{
        repository.upsert(item)
    }
    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch{
        repository.delete(item)
    }
    fun getAllItems() = repository.getAllItems()

}