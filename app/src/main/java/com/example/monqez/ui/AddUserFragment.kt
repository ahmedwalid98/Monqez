package com.example.monqez.ui

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
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
        binding.profileImage.setOnClickListener {
            val cInt = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cInt, Image_Capture_Code)
        }
        return binding.root
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == Image_Capture_Code) {
            if (resultCode == Activity.RESULT_OK) {
                val bp = data?.extras?.get("data") as Bitmap
                binding.profileImage.setImageBitmap(bp)

            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(requireContext(), "Cancelled", Toast.LENGTH_LONG).show()
            }
        }


    }
    private fun validate() : Boolean {
        var isValidate = true;
        if (binding.name.text!!.isEmpty()) {
            binding.regName.error = "Please enter your name"
            isValidate = false
        }
        if (binding.bloodType.text!!.isEmpty()) {
            binding.regBloodType.error = "Please enter your blood type"
            isValidate = false
        }
        if (binding.email.text!!.isEmpty()) {
            binding.regEmail.error = "Please enter your email"
            isValidate = false
        }
        if (binding.phone.text!!.isEmpty()) {
            binding.regPhoneNo.error = "Please enter your phone"
            isValidate = false
        }
        if (binding.password.text!!.isEmpty()) {
            binding.regPassword.error = "Please enter your password"
            isValidate = false
        }
        return isValidate
    }

}