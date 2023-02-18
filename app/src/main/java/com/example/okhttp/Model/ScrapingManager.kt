package com.example.okhttp.Model

import android.util.Log
import com.example.okhttp.Model.Entity.Embassy
import com.example.okhttp.Model.Entity.Flag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import java.io.IOException

class ScrapingManager {
    class UrlCreate(val region: XmlManager.Region, val flag: Flag) {
        val mainUrl: String
            get() = "https://www.mofa.go.jp/mofaj/annai/zaigai/list/${region.urlPath}/${flag.flagType.urlPath}.html"
    }

    val listData = mutableListOf<Embassy>()
    suspend fun fetchUrl(url: String): MutableList<Embassy> {
        return withContext(Dispatchers.IO) {
            val doc = Jsoup.connect(url).get()
            val items = doc.select(".main-section.section")
            for(i in 0 until items.size) {
                val title = items.select("h2.title2").eq(i).text()
                val address = items.select("div.any-area").eq(i).text()
                Log.d("確認タイトル", "${title}")
                Log.d("確認タイトル", "${address}")
                listData.add(Embassy(title, address))
            }
            Log.d("scrapingManagerデバッグ", "${listData}")
            return@withContext listData
        }
    }
}