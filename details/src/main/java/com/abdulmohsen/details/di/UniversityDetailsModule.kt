package com.abdulmohsen.details.di

import com.abdulmohsen.details.data.repository.UniversityDetailsRepositoryImpl
import com.abdulmohsen.local.database.UniversitiesDao
import com.abdulmohsen.details.domain.repository.UniversityDetailsRepository
import com.abdulmohsen.details.domain.usecase.GetUniversityDetailsUseCase
import com.abdulmohsen.details.presentation.UniversityDetailsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class UniversityDetailsModule {
    @Provides
    fun providesUniversityDetailsRepository(
        universitiesDao: UniversitiesDao
    ): UniversityDetailsRepository =
        UniversityDetailsRepositoryImpl(universitiesDao = universitiesDao)

    @Provides
    fun providesGetUniversityDetailsUseCase(
        repo: UniversityDetailsRepository
    ): GetUniversityDetailsUseCase =
        GetUniversityDetailsUseCase(universityDetailsRepository = repo)

    @Provides
    fun providesUniversityDetailsViewModelFactory(
        getUniversityDetailsUseCase: GetUniversityDetailsUseCase,
        name: String
    ): UniversityDetailsViewModelFactory =
        UniversityDetailsViewModelFactory(
            getUniversityDetailsUseCase = getUniversityDetailsUseCase,
            name = name
        )
}