package org.devdias.teslanewsapi_mvvm.di.module

import dagger.Module
import dagger.Provides
import org.devdias.teslanewsapi_mvvm.api.RetrofitServiceInterface
import org.devdias.teslanewsapi_mvvm.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
/**
 * Created by Dias Bakhtybek on 03.08.2021.
 * Application class
 **/
@Module
class RetrofitModule {
    //Method generating dependencies
    @Singleton
    @Provides
    fun getRetrofitServiceInterface(retrofit: Retrofit): RetrofitServiceInterface {
        return retrofit.create(RetrofitServiceInterface::class.java)
    }

    //Method generating dependencies
    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}