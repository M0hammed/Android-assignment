package com.abdulmohsen.androidassignment.di

import com.abdulmohsen.universities.di.UniversitiesComponent
import dagger.Module

@Module(
    subcomponents = [
        UniversitiesComponent::class
    ]
)
class AppSubComponentModule