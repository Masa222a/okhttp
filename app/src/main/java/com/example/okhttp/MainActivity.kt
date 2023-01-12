package com.example.okhttp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.okhttp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.squareup.picasso.Picasso
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var adapter: CustomAdapter? = null
    private var flagList = mutableListOf<Flag>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            flagList = getXmlData()
        } catch (e:XmlPullParserException) {
            Log.d("$e", "XmlPullParserException")
        } catch (e:IOException) {
            Log.d("$e", "IOException")
        }

        val recyclerView = binding.recyclerView
        adapter = CustomAdapter(flagList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        val tab = binding.tabLayout
        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            @SuppressLint("NotifyDataSetChanged")
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    var regionCountries = changeCountriesList(flagList, tab.position)
                    adapter?.flagList = regionCountries
                    adapter?.notifyDataSetChanged()
                    Toast.makeText(applicationContext, "${tab.position}", Toast.LENGTH_LONG).show()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(applicationContext, "${tab?.position}onTabUnselected", Toast.LENGTH_LONG).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(applicationContext, "${tab?.position}onTabReselected", Toast.LENGTH_LONG).show()
            }

        })

        adapter!!.setOnCountryClickListener(
            object : CustomAdapter.OnCountryCellClickListener {
                override fun onItemClick(flag: Flag) {
                    Toast.makeText(applicationContext, "${flag}", Toast.LENGTH_LONG).show()
                    val fragment = DetailFragment()
                    val bundle = Bundle()
//                    bundle.putSerializable("countryDetail", flag)
//                    fragment.arguments = bundle
//                    Log.d("bundle", "$bundle")
//                    parentFragmentManager
//                        .beginTransaction()
//                        .replace(R.id.container, fragment)
//                        .addToBackStack(null)
//                        .commit()
                }
            }
        )
    }

    fun changeCountriesList(flagList: MutableList<Flag>, position: Int): MutableList<Flag> {
        var regionCountry = mutableListOf<Flag>()
        for (count in 0 until flagList.count()) {
            when(position) {
                0 -> {
                    if (count in 0..17) {
                        regionCountry.add(flagList[count])
                    }
                    Log.d("デバッグ0", "${regionCountry}")
                }
                1 -> {
                    if (count in 18..29) {
                        regionCountry.add(flagList[count])
                    }
                    Log.d("デバッグ1", "${regionCountry}")
                }
                2 -> {
                    if (count in 30..45) {
                        regionCountry.add(flagList[count])
                    }
                    Log.d("デバッグ2", "${regionCountry}")
                }
                3 -> {
                    if (count in 46..47) {
                        regionCountry.add(flagList[count])
                    }
                    Log.d("デバッグ3", "${regionCountry}")
                }
                4 -> {
                    if (count in 48..68) {
                        regionCountry.add(flagList[count])
                    }
                    Log.d("デバッグ4", "${regionCountry}")
                }
                5 -> {
                    if (count in 69..80) {
                        regionCountry.add(flagList[count])
                    }
                    Log.d("デバッグ5", "${regionCountry}")
                }
                6 -> {
                    if (count in 81..129) {
                        regionCountry.add(flagList[count])
                    }
                    Log.d("デバッグ6", "${regionCountry}")
                }
                7 -> {
                    if (count in 130..150) {
                        regionCountry.add(flagList[count])
                    }
                    Log.d("デバッグ7", "${regionCountry}")
                }
                8 -> {
                    if (count in 151..198) {
                        regionCountry.add(flagList[count])
                    }
                    Log.d("デバッグ8", "${regionCountry}")
                }
            }
        }
        Log.d("デバッグresult", "${regionCountry.count()}")
        return regionCountry
    }

    private fun getXmlData() : MutableList<Flag> {
        val parser = applicationContext.resources.getXml(R.xml.country_information)
        var flags = mutableListOf<Flag>()
        var tagName: String? = null
        var eventType = parser.eventType

        var countriesName = mutableListOf<String>()
        var countriesEngName = mutableListOf<String>()
        var pictureIds = mutableListOf<Int>()
        var populations = mutableListOf<String>()
        var languages = mutableListOf<String>()
        var capitals = mutableListOf<String>()
        var currencies = mutableListOf<String>()
        while (eventType != XmlPullParser.END_DOCUMENT) {
            when(eventType) {
                XmlPullParser.START_DOCUMENT -> {

                }
                XmlPullParser.START_TAG -> {
                    tagName = parser.name
                }
                XmlPullParser.TEXT -> {
                    if(tagName != null) {
                        when(tagName) {
                            "name" -> {
                                countriesName.add(parser.text)
                            }
                            "flag" -> {
                                countriesEngName.add(parser.text)
                                if (applicationContext != null) {
                                    pictureIds.add(
                                        resources.getIdentifier(
                                            parser.text,
                                            "drawable",
                                            applicationContext.packageName
                                        )
                                    )
                                }
                            }
                            "population" -> {
                                populations.add(parser.text)
                            }
                            "language" -> {
                                languages.add(parser.text)
                            }
                            "capital" -> {
                                capitals.add(parser.text)
                            }
                            "currency" -> {
                                currencies.add(parser.text)
                            }
                        }
                    }
                }
            }
            eventType = parser.next()
        }

        parser.close()

        for(i in 0..pictureIds.size - 1) {
            flags.add(Flag(pictureIds[i], countriesName[i], countriesEngName[i], populations[i], languages[i], capitals[i], currencies[i]))
        }
        return flags

    }

    data class Flag(
        val pictureId: Int,
        val name: String?,
        val engName: String?,
        val population: String?,
        val language: String?,
        val capital: String?,
        val currency: String?
    )

    class CustomAdapter(var flagList: MutableList<Flag>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
        private lateinit var listener: OnCountryCellClickListener

        interface OnCountryCellClickListener {
            fun onItemClick(flag: Flag)
        }

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val image: ImageView = view.findViewById(R.id.flag_imageview)
            val countryName: TextView = view.findViewById(R.id.country_name)
            val population: TextView = view.findViewById(R.id.population_textview)
            val language: TextView = view.findViewById(R.id.language_textview)
            val capital: TextView = view.findViewById(R.id.capital_name)
            val currency: TextView = view.findViewById(R.id.currency_textview)
            val button: Button = view.findViewById(R.id.to_detail_button)
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_items, viewGroup, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            val flag = flagList[position]
            Picasso.get().load(flag.pictureId).resize(120, 80).into(viewHolder.image)
            viewHolder.countryName.text = flag.name
            viewHolder.population.text = flag.population
            viewHolder.language.text = flag.language
            viewHolder.capital.text = flag.capital
            viewHolder.currency.text = flag.currency
            viewHolder.button.setOnClickListener {
                listener.onItemClick(flag)
            }
        }

        override fun getItemCount(): Int = flagList.size

        fun setOnCountryClickListener(listener: OnCountryCellClickListener) {
            this.listener = listener
        }
    }
}