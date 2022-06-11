package com.example.shoestoreproject.mainActivity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestoreproject.models.Shoe

class ActivityViewModel():ViewModel() {

    enum class SaveState {
        SAVE,
        RESET
    }

    //Shoelist data holder
    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    //Livedata that communicates with UI
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private var _saveState = MutableLiveData<SaveState>()
    val saveState : LiveData<SaveState>
        get() = _saveState

    init{
        _shoeList.value = mutableListOf()
        _saveState.value = SaveState.RESET
    }

    //Initialing a list to set as the value for the MutableLiveData
    var shoeListData = mutableListOf<Shoe>()

    //Adding shoe to the list and then setting _shoeList.value as the mutablelist
    fun addToList(name: String, size: Double, company: String, description: String){
        shoeListData.add(Shoe(name, size, company, description))
        _shoeList.value = shoeListData
     //   Log.i("ActivityViewModel", _shoeList.value.toString())
    }

    fun onSaveState(name: String, size: String, company: String, description: String){
        var sizeDouble : Double = 0.0
        try {
            sizeDouble = size.toDouble()
        } catch (e: NumberFormatException) {
            Log.i("ActivityViewModel","Invalid size entered")
        }
        addToList(name, sizeDouble, company, description)
        _saveState.value = SaveState.SAVE
    }

    fun onEventFinished(){
        _saveState.value = SaveState.RESET
    }

}