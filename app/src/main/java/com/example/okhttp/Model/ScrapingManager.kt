package com.example.okhttp.Model

import android.util.Log
import com.example.okhttp.Model.Entity.Embassy
import com.example.okhttp.Model.Entity.Flag
import com.example.okhttp.Model.Entity.flagType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import java.io.IOException

class ScrapingManager {
    class UrlCreate(val Regions: XmlManager.Regions) {
        enum class Embassies(val region: XmlManager.Regions){
            asia(XmlManager.Regions.Asia),
            oceania(XmlManager.Regions.Oceania),
            n_ame(XmlManager.Regions.NorthAmerica),
            cs_ame(XmlManager.Regions.CentralNorthAmerica),
            europe(XmlManager.Regions.Europe),
            nm_east(XmlManager.Regions.MiddleEast),
            africa(XmlManager.Regions.Africa)
        }

        private val mainUrl: () -> String
            get() = {
                "https://www.mofa.go.jp/mofaj/annai/zaigai/list/${Regions.urlPath}/${flagType.urlPath}"
            }

    }





    private val listData = mutableListOf<Embassy>()
    private suspend fun fetchUrl(url: String) {
        return withContext(Dispatchers.IO) {
            try {
                val doc = Jsoup.connect(url).get()
                val items = doc.select(".main-section.section")
                for(i in 0 until items.size) {
                    val title = items.select("h2.title2").eq(i).text()
                    val address = items.select("div.any-area").eq(i).text()
                    Log.d("確認タイトル", "${title}")
                    Log.d("確認タイトル", "${address}")
                    listData.add(Embassy(title, address))
                }
            } catch (e: IOException) {
                e.stackTrace
            }
        }
    }
}