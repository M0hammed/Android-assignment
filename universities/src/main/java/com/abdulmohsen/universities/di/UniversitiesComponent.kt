package com.abdulmohsen.universities.di

import com.abdulmohsen.universities.presentation.UniversitiesFragment
import dagger.Subcomponent

@Subcomponent(modules = [UniversitiesModule::class])
interface UniversitiesComponent {
    fun inject(universitiesFragment: UniversitiesFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): UniversitiesComponent
    }
}