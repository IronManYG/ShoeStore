package com.udacity.shoestore.models

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import java.util.ArrayList

class ShoeViewModel : ViewModel() {

    private val _shoesList = MutableLiveData<ArrayList<Shoe>>()
    val shoesList: LiveData<ArrayList<Shoe>>
        get() = _shoesList

    fun saveButtonClick(view: View, shoe: Shoe){
        _shoesList.value?.add(shoe)
        view.findNavController().navigateUp()
    }

    init {
        _shoesList.value = ArrayList()
    }

}