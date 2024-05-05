package com.abdulmohsen.details.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.abdulmohsen.details.domain.usecase.GetUniversityDetailsUseCase
import javax.inject.Inject

class UniversityDetailsViewModelFactory @Inject constructor(
    private val getUniversityDetailsUseCase: GetUniversityDetailsUseCase,
    private val name: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return UniversityDetailsViewModel(getUniversityDetailsUseCase, name) as T
    }
}