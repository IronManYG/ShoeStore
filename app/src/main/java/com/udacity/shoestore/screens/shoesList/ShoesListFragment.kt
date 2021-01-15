package com.udacity.shoestore.screens.shoesList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoesListFragmentBinding
import com.udacity.shoestore.databinding.ShoesListItemBinding
import com.udacity.shoestore.models.ShoeViewModel

class ShoesListFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel

    private lateinit var shoeListLayout: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: ShoesListFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoes_list_fragment, container, false)

        // Get the viewModel
        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        //binding.lifecycleOwner = this

        shoeListLayout = binding.shoesListLayout

        viewModel.shoesList.observe(viewLifecycleOwner, { shoesList ->
            shoesList.forEach { shoe ->
                val listItemBinding = ShoesListItemBinding.inflate(layoutInflater, null, false)
                listItemBinding.shoe = shoe
                shoeListLayout.addView(listItemBinding.root)
                //addShoe(shoe.name, shoe.company, shoe.size, shoe.description)
            }
        })

        binding.addShoe.setOnClickListener{
            findNavController().navigate(ShoesListFragmentDirections.actionShoesListFragmentToShoeDetail())
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout_menu_item){
            findNavController().navigate(ShoesListFragmentDirections.actionShoesListFragmentToLoginFragment())
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addShoe(shoeName:String, shoeCompany: String, shoeSize: Double, shoeDescription:String){

        val shoeTextView = TextView(activity)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        params.setMargins(0,0,0,16)

        shoeTextView.layoutParams = params

        shoeTextView.setBackgroundColor(resources.getColor(R.color.design_default_color_secondary))

        shoeTextView.setTextColor(resources.getColor(R.color.design_default_color_background))

        shoeTextView.setPadding(16,16,16,16)

        shoeTextView.text = getString(R.string.shoe_detail_s, shoeName, shoeCompany, shoeSize, shoeDescription)

        shoeListLayout.addView(shoeTextView)
    }

}