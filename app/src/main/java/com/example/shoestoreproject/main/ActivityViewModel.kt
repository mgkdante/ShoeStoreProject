package com.example.shoestoreproject.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestoreproject.models.Shoe

class ActivityViewModel():ViewModel() {
    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private var shoeListData = mutableListOf<Shoe>()

    fun addToList(shoe: Shoe){
        shoeListData.add(shoe)
        _shoeList.value = shoeListData
     //   Log.i("ActivityViewModel", _shoeList.value.toString())

    }

}