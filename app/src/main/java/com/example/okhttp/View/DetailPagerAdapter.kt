package com.example.okhttp.View

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.okhttp.Controller.Fragment.DetailEmbassyFragment
import com.example.okhttp.Controller.Fragment.DetailVisaFragment

class DetailPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
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