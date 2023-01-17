package com.example.okhttp.Controller.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.okhttp.R
import com.example.okhttp.databinding.FragmentDetailEmbassyBinding

class DetailEmbassyFragment : Fragment() {
    lateinit var binding: FragmentDetailEmbassyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailEmbassyBinding.inflate(inflater, container, false)
        return binding.root
    }

}