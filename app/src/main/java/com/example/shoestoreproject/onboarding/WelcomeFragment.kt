package com.example.shoestoreproject.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestoreproject.R
import com.example.shoestoreproject.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcome,container, false)
        binding.continueButton.setOnClickListener{
            navigateToList()
        }

        return binding.root
    }

    //setting controller to navigate to instructions fragment
    private fun navigateToList(){
        findNavController().navigate(R.id.instructionsFragment)
    }

}