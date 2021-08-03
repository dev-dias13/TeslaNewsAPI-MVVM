package org.devdias.teslanewsapi_mvvm.di.component

import dagger.Component
import org.devdias.teslanewsapi_mvvm.di.module.RetrofitModule
import org.devdias.teslanewsapi_mvvm.viewModel.MainViewModel
import javax.inject.Singleton
/**
 * Created by Dias Bakhtybek on 03.08.2021.
 * Interface AppComponent
 **/
@Singleton
@Component(modules = [RetrofitModule::class])
interface AppComponent {
    fun inject(mainViewModel: MainViewModel)
}