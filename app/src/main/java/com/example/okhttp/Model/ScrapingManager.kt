package com.example.okhttp.Model

import com.example.okhttp.Model.Entity.Embassy
import com.example.okhttp.Model.Entity.Flag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class ScrapingManager {
    class UrlCreate(val region: XmlManager.Region, val flag: Flag) {
        val mainUrl: String
            get() = "https://www.mofa.go.jp/mofaj/annai/zaigai/list/${region.urlPath}/${flag.flagType.urlPath}.html"
    }

    val listData = mutableListOf<Embassy>()
    suspend fun fetchUrl(url: String): MutableList<Embassy> {
        return withContext(Dispatchers.Default) {
            val doc = Jsoup.connect(url).get()
            val items = doc.select(".main-section.section")
            items.select("br").append("\\n")
            for(i in 0 until items.size) {
                val title = items.select("h2.title2").eq(i).text()
                val address = items.select("div.any-area").eq(i).text()
                if (address.contains("\\n")) {
                    address.replace("\\n", "\n")
                }
                listData.add(Embassy(title, address))
            }
            return@withContext listData
        }
    }
}