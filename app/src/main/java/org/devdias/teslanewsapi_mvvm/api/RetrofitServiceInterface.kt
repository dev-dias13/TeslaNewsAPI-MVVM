package org.devdias.teslanewsapi_mvvm.api

import org.devdias.teslanewsapi_mvvm.model.NewsResponse
import org.devdias.teslanewsapi_mvvm.utils.Constants.Companion.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
/**
 * Created by Dias Bakhtybek on 03.08.2021.
 * Interface for sending GET request (Retrofit)
 **/
interface RetrofitServiceInterface {
     @GET("everything")
    fun getPostFromAPI(
         @Query("q", encoded=true) q: String = "tesla",
         @Query("from", encoded=true) from: String = "2021-07-03",
         @Query("sortBy", encoded = true) sortBy: String = "publishedAt",
         @Query("apiKey", encoded=true) api: String = API_KEY,
    ): Call<NewsResponse>
}