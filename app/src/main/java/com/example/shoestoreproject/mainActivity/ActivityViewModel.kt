package com.example.shoestoreproject.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestoreproject.models.Shoe

class ActivityViewModel():ViewModel() {

    //Shoelist data holder
    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    //Livedata that communicates with UI
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    //Initialing a list to set as the value for the MutableLiveData
    private var shoeListData = mutableListOf<Shoe>()

    //Adding shoe to the list and then setting _shoeList.value as the mutablelist
    fun addToList(shoe: Shoe){
        shoeListData.add(shoe)
        _shoeList.value = shoeListData
     //   Log.i("ActivityViewModel", _shoeList.value.toString())

    }

}