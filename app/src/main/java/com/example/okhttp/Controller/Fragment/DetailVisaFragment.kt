package com.example.okhttp.Controller.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.okhttp.R
import com.example.okhttp.databinding.FragmentDetailVisaBinding

class DetailVisaFragment : Fragment() {
    lateinit var binding: FragmentDetailVisaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailVisaBinding.inflate(inflater, container, false)
        return binding.root
    }

}