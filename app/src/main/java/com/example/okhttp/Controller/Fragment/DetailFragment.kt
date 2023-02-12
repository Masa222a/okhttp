package com.example.okhttp.Controller.Fragment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.okhttp.Model.DetailManager
import com.example.okhttp.Model.Entity.Flag
import com.example.okhttp.View.DetailPagerAdapter
import com.example.okhttp.databinding.FragmentDetailBinding
import com.google.android.material.tabs.TabLayoutMediator

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val tabTitleList = listOf("ビザ・渡航", "大使館")
    private val detailManager = DetailManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val flag = arguments?.getSerializable("country") as? Flag
        Log.d("DetailFragmentデバッグ", "$flag")

        val tabLayout = binding.tabLayout
        val viewPager = binding.detailViewPager
        viewPager.adapter = DetailPagerAdapter(parentFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitleList[position]
        }.attach()

        binding.backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

        val collapsingToolBar = binding.collapsingToolBar
        if (flag != null) {
            collapsingToolBar.title = flag.name
            collapsingToolBar.setCollapsedTitleTextColor(Color.WHITE)
            collapsingToolBar.setExpandedTitleColor(Color.WHITE)
            detailManager.setPhoto(binding.eachCountryPhoto, flag.engName)
        }

        return binding.root
    }

}