package com.example.shoestoreproject.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoestoreproject.models.Shoe

class ShoeListingViewModelFactory(private val shoe: Shoe): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ActivityViewModel::class.java)) {
            return ActivityViewModel(shoe) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}