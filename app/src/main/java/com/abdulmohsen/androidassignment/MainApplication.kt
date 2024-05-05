package com.abdulmohsen.androidassignment

import android.app.Application
import com.abdulmohsen.androidassignment.di.AppComponent
import com.abdulmohsen.androidassignment.di.DaggerAppComponent
import com.abdulmohsen.details.di.UniversityDetailsComponent
import com.abdulmohsen.details.di.UniversityDetailsComponentProvider
import com.abdulmohsen.universities.di.UniversitiesComponent
import com.abdulmohsen.universities.di.UniversitiesComponentProvider

class MainApplication : Application(),
    UniversitiesComponentProvider,
    UniversityDetailsComponentProvider {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    override fun provideUniversitiesComponent(): UniversitiesComponent =
        appComponent.getUniversitiesComponentFactory().create()

    override fun provideUniversityDetailsComponent(name: String): UniversityDetailsComponent =
        appComponent.getUniversityDetailsComponentFactory().create(name)
}
