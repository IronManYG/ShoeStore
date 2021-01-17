package com.udacity.shoestore.models

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.udacity.shoestore.Event
import java.util.ArrayList

class ShoeViewModel : ViewModel() {

    var isShoeEmpty: Boolean = false

    private val _shoesList = MutableLiveData<ArrayList<Shoe>>()
    val shoesList: LiveData<ArrayList<Shoe>>
        get() = _shoesList

    private val statusMessage = MutableLiveData<Event<String>>()
    val message : LiveData<Event<String>>
        get() = statusMessage

    fun saveButtonClick(view: View, shoe: Shoe){
        isShoeEmpty = if(shoe.name != "" && shoe.company != "" && shoe.size != 0.0 && shoe.description != "") {
            _shoesList.value?.add(shoe)
            view.findNavController().navigateUp()
            true
        }
        else{
            statusMessage.value = Event("Please fill in all the fields.")
            false
        }
    }

    init {
        _shoesList.value = ArrayList()
    }

}