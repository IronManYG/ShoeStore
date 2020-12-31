package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.WelcomeScreenFragmentBinding
import com.udacity.shoestore.screens.login.LoginFragmentDirections

class WelcomeScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: WelcomeScreenFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.welcome_screen_fragment, container, false)

        binding.nextButtonToInstructions.setOnClickListener{
            findNavController().navigate(WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToInstructionFragment())
        }

        return binding.root
    }

}