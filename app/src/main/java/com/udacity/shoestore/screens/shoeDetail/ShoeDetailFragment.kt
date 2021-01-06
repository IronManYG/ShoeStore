package com.udacity.shoestore.screens.shoeDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: ShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_detail, container, false)

        binding.cancelButton.setOnClickListener{
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailToShoesListFragment())
        }

        binding.saveButton.setOnClickListener{
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailToShoesListFragment())
        }

        return binding.root
    }

    fun addShoe(){

    }

}