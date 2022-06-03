package com.example.shoestoreproject.newShoe

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.shoestoreproject.R
import com.example.shoestoreproject.databinding.FragmentNewShoeBinding

class newShoeFragment : Fragment() {

    private lateinit var viewModel: NewShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this)[NewShoeViewModel::class.java]

        val binding: FragmentNewShoeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_shoe, container, false)
        return binding.root
    }

}