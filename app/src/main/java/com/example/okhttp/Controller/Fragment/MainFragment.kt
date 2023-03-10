package com.example.okhttp.Controller.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.okhttp.Model.Entity.Flag
import com.example.okhttp.Model.XmlManager
import com.example.okhttp.R
import com.example.okhttp.View.CountriesListAdapter
import com.example.okhttp.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayout
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private var adapter: CountriesListAdapter? = null
    private var flagList = listOf<Flag>()
    var xmlManager = XmlManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        try {
            flagList = xmlManager.changeCountriesList(XmlManager.Region.Asia)
        } catch (e: XmlPullParserException) {
            Log.d("$e", "XmlPullParserException")
        } catch (e: IOException) {
            Log.d("$e", "IOException")
        }

        adapter = CountriesListAdapter(flagList)
        val recyclerView = binding.recyclerView
        val tab = binding.tabLayout
        recyclerView.layoutManager = LinearLayoutManager(view?.context)
        recyclerView.adapter = adapter

        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            @SuppressLint("NotifyDataSetChanged")
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    val regionCountries = xmlManager.changeCountriesList(XmlManager.Region.indexOf(tab.position))
                    adapter?.flagList = regionCountries
                    recyclerView.scrollToPosition(0)
                    adapter?.notifyDataSetChanged()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                recyclerView.scrollToPosition(0)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                recyclerView.scrollToPosition(0)
            }

        })

        adapter!!.setOnCountryClickListener(
            object : CountriesListAdapter.OnCountryCellClickListener {
                override fun onItemClick(flag: Flag) {
                    val fragment = DetailFragment()
                    val bundle = Bundle()
                    bundle.putSerializable("country", flag)
                    fragment.arguments = bundle
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, fragment)
                        .addToBackStack(null)
                        .commit()
                }
            }
        )

        return binding.root
    }

}