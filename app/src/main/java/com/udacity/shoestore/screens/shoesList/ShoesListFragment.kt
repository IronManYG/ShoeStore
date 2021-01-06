package com.udacity.shoestore.screens.shoesList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoesListFragmentBinding

class ShoesListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: ShoesListFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoes_list_fragment, container, false)

        binding.addShoe.setOnClickListener{
            findNavController().navigate(ShoesListFragmentDirections.actionShoesListFragmentToShoeDetail())
        }

        return binding.root
    }

}