package com.example.okhttp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.okhttp.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private var flagList = mutableListOf<Flag>()
    private lateinit var binding: ActivityMainBinding

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
        recyclerView.adapter = CustomAdapter(flagList)
        recyclerView.layoutManager = LinearLayoutManager(this)

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

    class CustomAdapter(private val flagList: MutableList<Flag>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

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
//            viewHolder.image.setImageResource(flag.pictureId)
            Picasso.get().load(flag.pictureId).resize(120, 80).into(viewHolder.image)
            viewHolder.countryName.text = flag.name
            viewHolder.population.text = flag.population
            viewHolder.language.text = flag.language
            viewHolder.capital.text = flag.capital
            viewHolder.currency.text = flag.currency
            viewHolder.button.id = position
        }

        override fun getItemCount(): Int = flagList.size
    }
}