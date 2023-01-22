package com.example.okhttp.Model

import android.util.Log
import com.example.okhttp.Model.Entity.Flag
import com.example.okhttp.R
import com.example.okhttp.SingletonContext
import org.xmlpull.v1.XmlPullParser

class XmlManager {
    private val context = SingletonContext.applicationContext()!!
    var flags = listOf<Flag>()
    init {
        getXmlData()
    }

    enum class Regions(val index: Int) {
        SoutheastAsia(0),
        CentralAsia(1),
        Oseania(2),
        NorthAmerica(3),
        CentralAmerica(4),
        SouthAmerica(5),
        Europe(6),
        NorthAfrica(7),
        Africa(8);

        val countryCodes: List<Int>
            get() = when(this) {
                //1..18
                SoutheastAsia -> (1..18).toList()
                //19..30
                CentralAsia -> (19..30).toList()
                //31..46
                Oseania -> (31..46).toList()
                //47..48
                NorthAmerica -> (47..48).toList()
                //49..69
                CentralAmerica -> (49..69).toList()
                //70..81
                SouthAmerica -> (70..81).toList()
                //82..130
                Europe -> (82..130).toList()
                //131..151
                NorthAfrica -> (131..151).toList()
                // 152..199
                Africa -> (152..199).toList()
            }
    }

    fun changeCountriesList(regions: Regions): List<Flag> {
        return flags.filter { it.id == regions.countryCodes.first() }
    }

    private fun getXmlData() {
        val parser = context.resources.getXml(R.xml.country_information)
        val flags = mutableListOf<Flag>()
        var tagName: String? = null
        var eventType = parser.eventType

        val countryCodes = mutableListOf<Int>()
        val countriesName = mutableListOf<String>()
        val countriesEngName = mutableListOf<String>()
        val pictureIds = mutableListOf<Int>()
        val populations = mutableListOf<String>()
        val languages = mutableListOf<String>()
        val capitals = mutableListOf<String>()
        val currencies = mutableListOf<String>()
        while (eventType != XmlPullParser.END_DOCUMENT) {
            when(eventType) {
                XmlPullParser.START_DOCUMENT -> {

                }
                XmlPullParser.START_TAG -> {
                    tagName = parser.name
                    if (tagName == "country") {
                        countryCodes.add(parser.getAttributeIntValue(null, "country_code", 0))
                    }
                }
                XmlPullParser.TEXT -> {
                    if(tagName != null) {
                        when(tagName) {
                            "name" -> {
                                countriesName.add(parser.text)
                            }
                            "flag" -> {
                                countriesEngName.add(parser.text)
                                pictureIds.add(
                                    context.resources.getIdentifier(
                                        parser.text,
                                        "drawable",
                                        context.packageName
                                    )
                                )
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

        for(i in 0 until pictureIds.size) {
            flags.add(Flag(countryCodes[i], pictureIds[i], countriesName[i], countriesEngName[i], populations[i], languages[i], capitals[i], currencies[i]))
        }
        this.flags = flags
    }
}