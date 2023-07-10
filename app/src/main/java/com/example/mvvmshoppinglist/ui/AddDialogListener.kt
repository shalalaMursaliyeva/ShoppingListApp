package com.example.mvvmshoppinglist.ui

import com.example.mvvmshoppinglist.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonCLicked(item: ShoppingItem)
}