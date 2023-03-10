package com.example.okhttp.Controller.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.okhttp.Model.Entity.Flag
import com.example.okhttp.Model.XmlManager
import com.example.okhttp.databinding.FragmentDetailVisaBinding

class DetailVisaFragment : Fragment() {
    lateinit var binding: FragmentDetailVisaBinding
    var xmlManager = XmlManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailVisaBinding.inflate(inflater, container, false)
        val flag = arguments?.getSerializable("flag") as Flag
        val data = xmlManager.changeVisaList(flag.id)

        binding.visaInfomation.text = data[0].content.replace(" +".toRegex(), "\n")

        return binding.root
    }

}