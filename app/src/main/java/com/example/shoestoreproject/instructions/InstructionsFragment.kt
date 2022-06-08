package com.example.shoestoreproject.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestoreproject.R
import com.example.shoestoreproject.databinding.FragmentInstructionsBinding
import com.example.shoestoreproject.databinding.FragmentWelcomeBinding

class InstructionsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentInstructionsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)

        //Setting click listener to navigate to next screen
        binding.instructionsButton.setOnClickListener {
                view -> view.findNavController().navigate(R.id.shoeListingFragment)
        }

        return binding.root
    }

}