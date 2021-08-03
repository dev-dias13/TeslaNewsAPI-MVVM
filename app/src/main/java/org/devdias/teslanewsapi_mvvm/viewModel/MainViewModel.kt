package org.devdias.teslanewsapi_mvvm.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import org.devdias.teslanewsapi_mvvm.TeslaApplication
import org.devdias.teslanewsapi_mvvm.api.RetrofitServiceInterface
import org.devdias.teslanewsapi_mvvm.model.NewsArticles
import org.devdias.teslanewsapi_mvvm.model.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
/**
 * Created by Dias Bakhtybek on 03.08.2021.
 * ViewModel class for MainActivity
 **/
class MainViewModel(application: Application): AndroidViewModel(application) {
    @Inject
    lateinit var retrofitServiceInterface: RetrofitServiceInterface

    private lateinit var liveDataList: MutableLiveData<List<NewsArticles>>

    init {
        (application as TeslaApplication).getRetrofitComponent().inject(this)
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<NewsArticles>>{
        return liveDataList
    }

    //Function for API call
    fun makeAPICall() {
        val call: Call<NewsResponse> = retrofitServiceInterface.getPostFromAPI()
        call.enqueue(object: Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful){
                    liveDataList.postValue(response.body()?.getArticles())
                } else {
                    liveDataList.postValue(null)
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                liveDataList.postValue(null)
            }
        })
    }
}