package com.example.shoestoreproject.shoeListing

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.shoestoreproject.main.ActivityViewModel
import com.example.shoestoreproject.R
import com.example.shoestoreproject.main.ShoeListingViewModelFactory
import com.example.shoestoreproject.databinding.FragmentShoeListingBinding
import com.example.shoestoreproject.models.Shoe


class ShoeListingFragment : Fragment() {
    private lateinit var binding: FragmentShoeListingBinding
    private val shoeList = mutableListOf<Shoe>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)

        binding.floatingActionButton.setOnClickListener {
                view -> view.findNavController().navigate(R.id.newShoeFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.linearLayoutList



        //DIRECT TRANSFER OF DATA (RECEIVER)
        /*     val addedShoe by navArgs<ShoeListingFragmentArgs>()

             addedShoe.shoe?.let { shoeList.add(it) }

             Log.i("SheListingFragment", shoeList.toString())

             Log.i("SheListingFragment", addedShoe.shoe.toString())
       */
    }
}