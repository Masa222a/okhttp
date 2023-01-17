package com.example.okhttp.Controller.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
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
        var toolbar = binding.detailToolbar

        var tabLayout = binding.tabLayout
        var viewPager = binding.detailViewPager
        viewPager.adapter = ViewPagerAdapter(parentFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitleList[position]
        }.attach()

        binding.backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        return binding.root
    }

    class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(fragmentManager, lifecycle) {

        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return when(position) {
                0 -> {
                    DetailEmbassyFragment()
                }
                1 -> {
                    DetailVisaFragment()
                }
                else -> {
                    DetailEmbassyFragment()
                }
            }
        }

    }

}