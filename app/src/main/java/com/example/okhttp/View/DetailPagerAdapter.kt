package com.example.okhttp.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.okhttp.Controller.Fragment.DetailEmbassyFragment
import com.example.okhttp.Controller.Fragment.DetailFragment
import com.example.okhttp.Controller.Fragment.DetailVisaFragment
import com.example.okhttp.Model.Entity.Flag

class DetailPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    var flag: Flag? = null

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> {
                val fragment = DetailVisaFragment()
                return fragment
            }
            1 -> {
                val fragment = DetailEmbassyFragment()
                val bundle = Bundle()
                bundle.putSerializable("flag", flag) as? Flag
                fragment.arguments = bundle
                return fragment
            }
            else -> {
                val fragment = DetailVisaFragment()
                return fragment
            }
        }
    }

    fun addData(country: Flag) {
        this.flag = country
    }
}