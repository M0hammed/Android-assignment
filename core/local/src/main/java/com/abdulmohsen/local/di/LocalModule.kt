package com.abdulmohsen.local.di

import android.app.Application
import com.abdulmohsen.local.database.UniversitiesDao
import com.abdulmohsen.local.database.UniversitiesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalModule {

    @Provides
    @Singleton
    fun providesUniversitiesDatabase(context: Application): UniversitiesDatabase =
        UniversitiesDatabase.build(context)

    @Provides
    @Singleton
    fun providesUniversitiesDoa(universitiesDatabase: UniversitiesDatabase): UniversitiesDao =
        universitiesDatabase.getAssessmentDao()
}