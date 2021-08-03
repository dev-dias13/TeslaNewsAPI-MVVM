package org.devdias.teslanewsapi_mvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Dias Bakhtybek on 03.08.2021.
 * Data class from received JSON response
 **/
class NewsResponse {
     @SerializedName("articles")
    @Expose
    private var articles: List<NewsArticles>? = null

    fun getArticles(): List<NewsArticles>? {
        return articles
    }
}