package com.example.okhttp.Model

import android.util.Log
import com.example.okhttp.R
import org.xmlpull.v1.XmlPullParser

class XmlManager {
    private val context = SingletonContext.applicationContext()!!

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
                SoutheastAsia -> listOf(1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18)
                //19..30
                CentralAsia -> listOf(19, 20, 21 ,22, 23, 24, 25, 26, 27, 28, 29, 30)
                //31..46
                Oseania -> listOf(31 ,32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46)
                //47..48
                NorthAmerica -> listOf(47, 48)
                //49..69
                CentralAmerica -> listOf(49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69)
                //70..81
                SouthAmerica -> listOf(70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81)
                //82..130
                Europe -> listOf(82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101,
                                102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121,
                                122, 123, 124, 125, 126, 127, 128, 129, 130)
                //131..151
                NorthAfrica -> listOf(131, 132, 133, 134, 135, 136, 137, 138, 139 ,140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151)
                // 152..199
                Africa -> listOf(152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170,
                                171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190,
                                191, 192, 193, 194, 195, 196, 197, 198, 199)
            }
    }

    fun changeCountriesList(flagList: MutableList<Flag>, position: Int): MutableList<Flag> {
        val regionCountry = mutableListOf<Flag>()
        for (flag in flagList) {
            when(position) {
                Regions.SoutheastAsia.index -> {
                    if (flag.id in Regions.SoutheastAsia.countryCodes) {
                        regionCountry.add(flag)
                    }
                    Log.d("デバッグ0", "$regionCountry")
                }
                Regions.CentralAsia.index -> {
                    if (flag.id in Regions.CentralAsia.countryCodes) {
                        regionCountry.add(flag)
                    }
                    Log.d("デバッグ1", "$regionCountry")
                }
                Regions.Oseania.index -> {
                    if (flag.id in Regions.Oseania.countryCodes) {
                        regionCountry.add(flag)
                    }
                    Log.d("デバッグ2", "$regionCountry")
                }
                Regions.NorthAmerica.index -> {
                    if (flag.id in Regions.NorthAmerica.countryCodes) {
                        regionCountry.add(flag)
                    }
                    Log.d("デバッグ3", "$regionCountry")
                }
                Regions.CentralAmerica.index -> {
                    if (flag.id in Regions.CentralAmerica.countryCodes) {
                        regionCountry.add(flag)
                    }
                    Log.d("デバッグ4", "$regionCountry")
                }
                Regions.SouthAmerica.index -> {
                    if (flag.id in Regions.SouthAmerica.countryCodes) {
                        regionCountry.add(flag)
                    }
                    Log.d("デバッグ5", "$regionCountry")
                }
                Regions.Europe.index -> {
                    if (flag.id in Regions.Europe.countryCodes) {
                        regionCountry.add(flag)
                    }
                    Log.d("デバッグ6", "$regionCountry")
                }
                Regions.NorthAfrica.index -> {
                    if (flag.id in Regions.NorthAfrica.countryCodes) {
                        regionCountry.add(flag)
                    }
                    Log.d("デバッグ7", "$regionCountry")
                }
                Regions.Africa.index -> {
                    if (flag.id in Regions.Africa.countryCodes) {
                        regionCountry.add(flag)
                    }
                    Log.d("デバッグ8", "$regionCountry")
                }
            }
        }

        Log.d("デバッグresult", "${regionCountry.count()}")
        return regionCountry
    }

    fun getXmlData() : MutableList<Flag> {
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
        return flags

    }
}