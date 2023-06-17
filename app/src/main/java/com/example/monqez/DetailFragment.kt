package com.example.monqez

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.monqez.databinding.FragmentDetailBinding
import com.example.monqez.pojo.User
import java.util.*

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container,false)
        val userAge = DetailFragmentArgs.fromBundle(requireArguments()).user.age
        val userfirstname = DetailFragmentArgs.fromBundle(requireArguments()).user.first_name
        val lat = DetailFragmentArgs.fromBundle(requireArguments()).user.lat
        val long = DetailFragmentArgs.fromBundle(requireArguments()).user.long
        binding.name.append(userfirstname)
        binding.age.append(userAge.toString())
        binding.email.append(DetailFragmentArgs.fromBundle(requireArguments()).user.email)
        binding.Address.append(DetailFragmentArgs.fromBundle(requireArguments()).user.str_address)
        binding.bloodType.append(DetailFragmentArgs.fromBundle(requireArguments()).user.blood_type)
        binding.gender.append(DetailFragmentArgs.fromBundle(requireArguments()).user.gender)
        binding.phone.append(DetailFragmentArgs.fromBundle(requireArguments()).user.phone_1)
        binding.button3.setOnClickListener {
            Toast.makeText(
                requireContext(),
                 lat + long,
                Toast.LENGTH_SHORT)
                .show()
            val uri = String.format(Locale.ENGLISH, "geo:%f,%f?z=18&q=%f,%f",lat.toFloat(), long.toFloat(),lat.toFloat(), long.toFloat())
            val intent  = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }
        return binding.root
    }
    

}