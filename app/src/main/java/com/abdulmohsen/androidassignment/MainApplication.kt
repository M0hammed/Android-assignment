package com.abdulmohsen.androidassignment

import android.app.Application
import com.abdulmohsen.androidassignment.di.AppComponent
import com.abdulmohsen.androidassignment.di.DaggerAppComponent

class MainApplication : Application(){

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}
