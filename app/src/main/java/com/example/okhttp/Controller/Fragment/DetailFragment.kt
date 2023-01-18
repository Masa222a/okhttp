package com.example.okhttp.Controller.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.okhttp.View.DetailPagerAdapter
import com.example.okhttp.databinding.FragmentDetailBinding
import com.google.android.material.tabs.TabLayoutMediator

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val tabTitleList = listOf("ビザ・渡航", "大使館")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        var tabLayout = binding.tabLayout
        var viewPager = binding.detailViewPager
        viewPager.adapter = DetailPagerAdapter(parentFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitleList[position]
        }.attach()

        binding.backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        return binding.root
    }

}