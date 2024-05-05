package com.abdulmohsen.details.di

import com.abdulmohsen.details.presentation.DetailsFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [UniversityDetailsModule::class])
interface UniversityDetailsComponent {
    fun inject(universityDetailsFragment: DetailsFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance name: String): UniversityDetailsComponent
    }
}