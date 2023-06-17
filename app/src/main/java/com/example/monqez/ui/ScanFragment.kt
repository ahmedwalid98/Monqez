package com.example.monqez.ui

import android.app.Activity.RESULT_CANCELED
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.opengl.Visibility
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Base64.encodeToString
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.example.monqez.Constants
import com.example.monqez.R
import com.example.monqez.databinding.FragmentScanBinding
import com.example.monqez.observeOnce
import com.example.monqez.pojo.UserReq
import com.example.monqez.repository.UserRepository
import com.example.monqez.viewModel.MainViewModel
import java.io.ByteArrayOutputStream
import java.util.*

const val Image_Capture_Code = 1

class ScanFragment : Fragment() {

    private lateinit var binding: FragmentScanBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var userReq:UserReq
    private lateinit var bp: Bitmap
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentScanBinding.inflate(inflater, container, false)
        val userRepository = UserRepository()
        val viewModelFactory = MainViewModel.MainViewModelFactory(userRepository)

        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(MainViewModel::class.java)
        viewModel.user.observe(viewLifecycleOwner) {
            it?.let {
                Log.i("user", "getUser: ${it.id}")
                Log.i("user", "getUser: ${it.first_name}")

                findNavController().navigate(ScanFragmentDirections.actionScanFragmentToDetailFragment(it))
            }
        }
        binding.scan.setOnClickListener {
            val cInt = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cInt, Image_Capture_Code)

        }
        binding.find.setOnClickListener {
            Log.i("Glitch 1", "glitch1")
            userReq =UserReq(
                data = convertBitmapToBase64(bp)
            )
            getUser(userReq)
        }


        return binding.root
    }
    private fun getUser(user: UserReq){
        viewModel.getUser(user)
    }

    override fun onPause() {
        super.onPause()
        Log.i("pause","pause")
        viewModel.clearUser()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            if (requestCode == Image_Capture_Code) {
                if (resultCode == RESULT_OK) {
                    bp = data?.extras?.get("data") as Bitmap
                    binding.imageView.setImageBitmap(bp)
                } else if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(requireContext(), "Cancelled", Toast.LENGTH_LONG).show()
                }
            }


    }
    private fun convertBitmapToBase64(bitmap: Bitmap): String
    {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG,50, stream)
        val image = stream.toByteArray()
        return Base64.encodeToString(image, Base64.DEFAULT)
    }
}