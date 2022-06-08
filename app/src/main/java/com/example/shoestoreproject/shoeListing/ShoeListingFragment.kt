package com.example.shoestoreproject.shoeListing

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import com.example.shoestoreproject.mainActivity.ActivityViewModel
import com.example.shoestoreproject.R
import com.example.shoestoreproject.databinding.FragmentShoeListingBinding
import com.example.shoestoreproject.databinding.ListItemViewBinding
import com.example.shoestoreproject.login.LoginFragmentDirections
import com.example.shoestoreproject.newShoe.NewShoeFragmentDirections


class ShoeListingFragment : Fragment() {


    private lateinit var binding: FragmentShoeListingBinding

    private val activityViewModel: ActivityViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)


        binding.floatingActionButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.newShoeFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityViewModel.shoeList.observe(viewLifecycleOwner) {
            activityViewModel.shoeList.value?.forEach {
                val itemBinding = ListItemViewBinding.inflate(
                    LayoutInflater.from(requireContext()),
                    binding.linearLayoutList,
                    false
                )

                itemBinding.CompanyView.text = it.company
                itemBinding.nameView.text = it.name
                itemBinding.sizeView.text = it.size.toString()
                itemBinding.descriptionView.text = it.description

                binding.linearLayoutList.addView(itemBinding.root)
            }
            Log.i("ShoeListingFragment", activityViewModel.shoeList.value.toString())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

   override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val action = ShoeListingFragmentDirections.actionShoeListingFragmentToLoginFragment()
        NavHostFragment.findNavController(this).navigate(action)
       return super.onOptionsItemSelected(item)

    }

}