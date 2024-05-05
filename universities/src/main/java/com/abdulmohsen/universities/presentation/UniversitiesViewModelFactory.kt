package com.abdulmohsen.universities.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abdulmohsen.universities.domain.usecase.GetUniversitiesListUseCase
import javax.inject.Inject

class UniversitiesViewModelFactory @Inject constructor(
    private val getUniversitiesListUseCase: GetUniversitiesListUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UniversitiesViewModel(getUniversitiesListUseCase) as T
    }
}