package com.example.shoestoreproject.login

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestoreproject.R
import com.example.shoestoreproject.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.loginButton.setOnClickListener {
            view -> view.findNavController().navigate(R.id.welcomeFragment)
        }

        binding.singupButton.setOnClickListener {
                view -> view.findNavController().navigate(R.id.welcomeFragment)
        }

        return binding.root
    }
}