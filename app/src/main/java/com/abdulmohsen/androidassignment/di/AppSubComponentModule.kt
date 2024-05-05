package com.abdulmohsen.androidassignment.di

import com.abdulmohsen.details.di.UniversityDetailsComponent
import com.abdulmohsen.universities.di.UniversitiesComponent
import dagger.Module

@Module(
    subcomponents = [
        UniversitiesComponent::class,
        UniversityDetailsComponent::class
    ]
)
class AppSubComponentModule