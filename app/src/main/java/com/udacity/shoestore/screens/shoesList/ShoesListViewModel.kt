package com.udacity.shoestore.screens.shoesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoesListViewModel : ViewModel() {

    private val _shoesList = MutableLiveData<String>()
    val shoesList: LiveData<String>
        get() = _shoesList


}