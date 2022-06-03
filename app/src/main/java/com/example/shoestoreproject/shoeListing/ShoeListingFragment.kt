package com.example.shoestoreproject.shoeListing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestoreproject.R
import com.example.shoestoreproject.databinding.FragmentShoeListingBinding


class ShoeListingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeListingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)
        binding.floatingActionButton.setOnClickListener {
                view -> view.findNavController().navigate(R.id.newShoeFragment)
        }
        binding.linearLayoutList

        return binding.root
    }


}