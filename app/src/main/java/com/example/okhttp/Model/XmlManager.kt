package com.example.okhttp.Model

import android.util.Log
import com.example.okhttp.R
import org.xmlpull.v1.XmlPullParser

class XmlManager {
    companion object {
        var instance: XmlManager = XmlManager()
    }

    fun changeCountriesList(flagList: MutableList<Flag>, position: Int): MutableList<Flag> {
        val regionCountry = mutableListOf<Flag>()
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
        val parser = requireActivity().resources.getXml(R.xml.country_information)
        val flags = mutableListOf<Flag>()
        var tagName: String? = null
        var eventType = parser.eventType

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
                }
                XmlPullParser.TEXT -> {
                    if(tagName != null) {
                        when(tagName) {
                            "name" -> {
                                countriesName.add(parser.text)
                            }
                            "flag" -> {
                                countriesEngName.add(parser.text)
                                if (activity != null) {
                                    pictureIds.add(
                                        resources.getIdentifier(
                                            parser.text,
                                            "drawable",
                                            requireActivity().packageName
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
}