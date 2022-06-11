package com.example.shoestoreproject.newShoe

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.shoestoreproject.databinding.FragmentNewShoeBinding
import com.example.shoestoreproject.mainActivity.ActivityViewModel
import com.example.shoestoreproject.models.Shoe


class NewShoeFragment : Fragment() {

    //setting up the values that the Shoe data class holds

    private lateinit var binding: FragmentNewShoeBinding
    private val activityViewModel: ActivityViewModel by activityViewModels()
    private val shoeData = Shoe("", 0.0, "", "")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentNewShoeBinding.inflate(inflater, container, false)

        binding.viewModel = activityViewModel
        binding.lifecycleOwner = this
        binding.shoeDataClass = shoeData


        binding.cancelButton.setOnClickListener {
            navigateToNextScreen()
        }

        activityViewModel.saveState.observe(this as LifecycleOwner, Observer { saveState ->
            when (saveState) {
                ActivityViewModel.SaveState.SAVE -> {
                    navigateToNextScreen()
                    activityViewModel.onEventFinished()
                }
            }
        })

        return binding.root
    }


    //setting navigation in reusable method
    private fun navigateToNextScreen() {
        val action = NewShoeFragmentDirections.actionNewShoeFragmentToShoeListingFragment()
        findNavController(this).navigate(action)
    }

}