package com.example.shoestoreproject.newShoe

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestoreproject.R
import com.example.shoestoreproject.databinding.FragmentNewShoeBinding
import com.example.shoestoreproject.mainActivity.ActivityViewModel
import com.example.shoestoreproject.models.Shoe
import kotlin.properties.Delegates

class NewShoeFragment : Fragment() {

    private lateinit var binding: FragmentNewShoeBinding
    private lateinit var shoe: Shoe
    private lateinit var nameValue: String
    private lateinit var companyValue: String
    private lateinit var descriptionValue: String
    private val activityViewModel: ActivityViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_shoe, container, false)


        binding.addShoeButton.setOnClickListener{
            addShoe()
            navigateToNextScreen()
        }

        return binding.root
    }

    private fun addShoe(){

        nameValue = binding.nameText.text.toString()
        companyValue = binding.companyText.text.toString()
        descriptionValue = binding.descriptionText.text.toString()
        val sizeValue = binding.sizeText.text.toString().toDoubleOrNull()

        shoe = Shoe(nameValue, sizeValue, companyValue, descriptionValue)

      //  Log.i("NewShoeFragment", shoe.toString())
        if (sizeValue == null){
            return
        }
        else
        activityViewModel.addToList(shoe)
    }

    private fun navigateToNextScreen(){
        val action = NewShoeFragmentDirections.actionNewShoeFragmentToShoeListingFragment()
        findNavController(this).navigate(action)
    }
}