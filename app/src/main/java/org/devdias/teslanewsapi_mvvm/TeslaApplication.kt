package org.devdias.teslanewsapi_mvvm

import android.app.Application
import org.devdias.teslanewsapi_mvvm.di.component.AppComponent
import org.devdias.teslanewsapi_mvvm.di.component.DaggerAppComponent
import org.devdias.teslanewsapi_mvvm.di.module.RetrofitModule

/**
 * Created by Dias Bakhtybek on 03.08.2021.
 * Application class
 **/

class TeslaApplication: Application() {
    private lateinit var retrofitComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        retrofitComponent = DaggerAppComponent.builder()
            .retrofitModule(RetrofitModule())
            .build()
    }

    fun getRetrofitComponent(): AppComponent {
        return retrofitComponent
    }
}