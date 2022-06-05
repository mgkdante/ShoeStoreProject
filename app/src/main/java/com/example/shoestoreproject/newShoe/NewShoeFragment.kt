package com.example.shoestoreproject.newShoe

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.shoestoreproject.R
import com.example.shoestoreproject.databinding.FragmentNewShoeBinding
import com.example.shoestoreproject.models.Shoe
import kotlin.properties.Delegates

class NewShoeFragment : Fragment() {

    private lateinit var binding: FragmentNewShoeBinding
    private lateinit var shoe: Shoe
    private lateinit var nameValue: String
    private lateinit var companyValue: String
    private lateinit var descriptionValue: String
    private var sizeValue by Delegates.notNull<Double>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_shoe, container, false)

        binding.addShoeButton.setOnClickListener{
            shoeAdded()
        }

        return binding.root
    }

    private fun shoeAdded(){

        nameValue = binding.nameText.text.toString()
        companyValue = binding.companyText.text.toString()
        descriptionValue = binding.descriptionText.text.toString()
        sizeValue = binding.sizeText.text.toString().toDouble()

        shoe = Shoe(nameValue, sizeValue, companyValue, descriptionValue)

        Log.i("NewShoeFragment", shoe.toString())



       //DIRECT TRANSFER OF DATA (SENDER)
      /* val action = NewShoeFragmentDirections.actionNewShoeFragmentToShoeListingFragment(shoe)
        findNavController(this).navigate(action)*/
    }

}