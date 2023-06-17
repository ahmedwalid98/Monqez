package com.example.monqez.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.monqez.R
import com.example.monqez.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    private lateinit var binding: FragmentInstructionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInstructionBinding.inflate(inflater, container, false)
        binding.button2.setOnClickListener {
            findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToScanFragment())
        }
        return binding.root
    }


}