package com.example.monqez.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.monqez.R
import com.example.monqez.databinding.FragmentAddUserBinding


class AddUserFragment : Fragment() {
    private lateinit var binding: FragmentAddUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentAddUserBinding.inflate(inflater,container,false)
        binding.addUser.setOnClickListener {
            if (validate()){
                val mProgressDialog = ProgressDialog(requireContext(), R.style.MyAlertDialogStyle)
                mProgressDialog.setTitle("Adding user")
                mProgressDialog.setMessage("Loading")
                mProgressDialog.show()
                Toast.makeText(requireContext(),"validate", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(),"not validate", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

    private fun validate() : Boolean {
        var isValidate = true;
        if (binding.name.text!!.isEmpty()) {
            binding.regName.error = "Please enter your name"
            isValidate = false
        }
        if (binding.bloodType.text!!.isEmpty()) {
            binding.regName.error = "Please enter your blood type"
            isValidate = false
        }
        if (binding.email.text!!.isEmpty()) {
            binding.regName.error = "Please enter your email"
            isValidate = false
        }
        if (binding.phone.text!!.isEmpty()) {
            binding.regName.error = "Please enter your phone"
            isValidate = false
        }
        if (binding.password.text!!.isEmpty()) {
            binding.regName.error = "Please enter your password"
            isValidate = false
        }
        return isValidate
    }

}