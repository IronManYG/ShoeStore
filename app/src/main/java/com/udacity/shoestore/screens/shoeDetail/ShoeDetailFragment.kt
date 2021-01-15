package com.udacity.shoestore.screens.shoeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: ShoeDetailBinding

    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_detail, container, false
        )

        // Get the viewModel
        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        // Set the viewModel for dataBinding - this allows the bound layout access to all of the
        // data in the VieWModel
        binding.shoeViewMode = viewModel

        binding.shoe = Shoe("", 0.0, "", "",images = mutableListOf())

        binding.lifecycleOwner = this

        binding.cancelButton.setOnClickListener{
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailToShoesListFragment())
        }

        return binding.root
    }

}