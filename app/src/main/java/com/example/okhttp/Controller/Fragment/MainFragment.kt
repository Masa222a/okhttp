package com.example.okhttp.Controller.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.okhttp.Model.Flag
import com.example.okhttp.Model.XmlManager
import com.example.okhttp.R
import com.example.okhttp.View.CustomAdapter
import com.example.okhttp.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayout
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    private var adapter: CustomAdapter? = null
    private var flagList = mutableListOf<Flag>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        // currentPositionを元にManagerクラスにポジションの情報を渡してデータをもらえるようにする。
        try {
            flagList = XmlManager().getXmlData()
        } catch (e: XmlPullParserException) {
            Log.d("$e", "XmlPullParserException")
        } catch (e: IOException) {
            Log.d("$e", "IOException")
        }

        val recyclerView = binding.recyclerView
        adapter = CustomAdapter(flagList)
        recyclerView.layoutManager = LinearLayoutManager(view?.context)
        recyclerView.adapter = adapter
        val tab = binding.tabLayout
        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            @SuppressLint("NotifyDataSetChanged")
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    val regionCountries = changeCountriesList(flagList, tab.position)
                    adapter?.flagList = regionCountries
                    adapter?.notifyDataSetChanged()
                    Toast.makeText(activity, "${tab.position}", Toast.LENGTH_LONG).show()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(activity, "${tab?.position}onTabUnselected", Toast.LENGTH_LONG).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(activity, "${tab?.position}onTabReselected", Toast.LENGTH_LONG).show()
            }

        })

        adapter!!.setOnCountryClickListener(
            object : CustomAdapter.OnCountryCellClickListener {
                override fun onItemClick(flag: Flag) {
                    Toast.makeText(activity, "${flag}", Toast.LENGTH_LONG).show()
                    val fragment = DetailFragment()
                    val bundle = Bundle()
                    bundle.putSerializable("country", flag)
                    fragment.arguments = bundle
                    Log.d("bundle", "$bundle")
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