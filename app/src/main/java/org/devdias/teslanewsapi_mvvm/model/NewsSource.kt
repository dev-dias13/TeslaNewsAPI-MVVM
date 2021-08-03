package org.devdias.teslanewsapi_mvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
/**
 * Created by Dias Bakhtybek on 03.08.2021.
 * Data class from getArticles field in NewsArticles
 **/
class NewsSource {
@SerializedName("id")
    @Expose
    private var id: String? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    fun getId(): String? {
        return id
    }


    fun getName(): String? {
        return name
    }
}
