package com.example.shoestoreproject.shoeListing

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.shoestoreproject.mainActivity.ActivityViewModel
import com.example.shoestoreproject.R
import com.example.shoestoreproject.databinding.EmptyListBinding
import com.example.shoestoreproject.databinding.FragmentShoeListingBinding
import com.example.shoestoreproject.databinding.ListItemViewBinding


class ShoeListingFragment : Fragment() {


    private lateinit var binding: FragmentShoeListingBinding

    private val activityViewModel: ActivityViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentShoeListingBinding.inflate(inflater, container, false)

        //Navigate to screen to add new shoe
        binding.floatingActionButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.newShoeFragment)
        }

        //Enabling menu to be used to logout
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //if the list is empty the Layout will inflate a specific layout for this case
        if (activityViewModel.shoeList.value.isNullOrEmpty()) {
            val emptyListBinding = EmptyListBinding.inflate(layoutInflater)
            binding.linearLayoutList.addView(emptyListBinding.root)
        }
        //Once the system observes a change it will inflate another layout in order to display the shoe information
        else {
            activityViewModel.shoeList.observe(viewLifecycleOwner) {
                for (shoe in activityViewModel.shoeList.value!!) {
                    val itemBinding = ListItemViewBinding.inflate(layoutInflater)
                    itemBinding.shoeDataClass = shoe
                    binding.linearLayoutList.addView(itemBinding.root)
                }

            }
        }
    }


    //inflating the dotted menu at the right top corner
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    //setting up the action when the menu item is clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val action = ShoeListingFragmentDirections.actionShoeListingFragmentToLoginFragment()
        NavHostFragment.findNavController(this).navigate(action)
        return super.onOptionsItemSelected(item)

    }

}