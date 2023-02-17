package com.example.okhttp.Controller.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.okhttp.Model.Entity.Embassy
import com.example.okhttp.Model.Entity.Flag
import com.example.okhttp.View.CountriesDetailEmbassyAdapter
import com.example.okhttp.databinding.FragmentDetailEmbassyBinding

class DetailEmbassyFragment : Fragment() {
    lateinit var binding: FragmentDetailEmbassyBinding
    private var adapter: CountriesDetailEmbassyAdapter? = null
    var embassyList = mutableListOf<Embassy>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailEmbassyBinding.inflate(inflater, container, false)
        adapter = CountriesDetailEmbassyAdapter(embassyList)
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(view?.context)
        recyclerView.adapter = adapter
        val flag = arguments?.getSerializable("flag") as Flag
        Log.d("EmbassyFragmentデバッグ", "$flag")
        return binding.root
    }

}