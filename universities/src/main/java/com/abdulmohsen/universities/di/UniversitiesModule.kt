package com.abdulmohsen.universities.di

import com.abdulmohsen.local.database.UniversitiesDao
import com.abdulmohsen.network.service.universty.UniversitiesListApi
import com.abdulmohsen.universities.data.repository.UniversitiesRepositoryImpl
import com.abdulmohsen.universities.domain.repository.UniversitiesRepository
import com.abdulmohsen.universities.domain.usecase.GetUniversitiesListUseCase
import com.abdulmohsen.universities.presentation.UniversitiesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class UniversitiesModule {
    @Provides
    fun providesUniversitiesRepository(
        universitiesListApi: UniversitiesListApi,
        universitiesDao: UniversitiesDao
    ): UniversitiesRepository =
        UniversitiesRepositoryImpl(
            universitiesListApi = universitiesListApi,
            universitiesDao = universitiesDao
        )

    @Provides
    fun providesGetUniversitiesListUseCase(repo: UniversitiesRepository): GetUniversitiesListUseCase =
        GetUniversitiesListUseCase(universitiesRepository = repo)

    @Provides
    fun providesUniversitiesViewModelFactory(getUniversitiesListUseCase: GetUniversitiesListUseCase): UniversitiesViewModelFactory =
        UniversitiesViewModelFactory(getUniversitiesListUseCase = getUniversitiesListUseCase)
}