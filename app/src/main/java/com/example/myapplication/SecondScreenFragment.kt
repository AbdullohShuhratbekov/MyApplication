package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentSecondScreenBinding

class SecondScreenFragment : Fragment() {

    private val binding:FragmentSecondScreenBinding by lazy {
        FragmentSecondScreenBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val number = arguments?.getInt("NAMBER")
        binding.goBackScreenBtn.setOnClickListener {
            findNavController()
                  .navigate(R.id.action_homeIcon_to_searchIcon)

        }
    }
}