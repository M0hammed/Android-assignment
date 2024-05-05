package com.abdulmohsen.androidassignment.di

import android.app.Application
import com.abdulmohsen.androidassignment.MainApplication
import com.abdulmohsen.local.di.LocalModule
import com.abdulmohsen.network.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, LocalModule::class, AppSubComponentModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MainApplication)
}