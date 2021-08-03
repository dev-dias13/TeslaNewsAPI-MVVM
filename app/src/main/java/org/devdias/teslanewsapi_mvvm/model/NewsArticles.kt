package org.devdias.teslanewsapi_mvvm.model

/**
 * Created by Dias Bakhtybek on 03.08.2021.
 * Data class from getArticles field in News Response
 **/

data class NewsArticles (
    val source: NewsSource,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
    )