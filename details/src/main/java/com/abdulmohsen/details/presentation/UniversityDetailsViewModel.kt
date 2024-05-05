package com.abdulmohsen.details.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdulmohsen.common.UiState
import com.abdulmohsen.details.domain.model.UniversityDetails
import com.abdulmohsen.details.domain.usecase.GetUniversityDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UniversityDetailsViewModel(
    private val getUniversityDetailsUseCase: GetUniversityDetailsUseCase,
    private val name: String
) : ViewModel() {
    private val uiState: MutableStateFlow<UiState<UniversityDetails>> =
        MutableStateFlow(UiState.Loading())
    val uiStateflow: StateFlow<UiState<UniversityDetails>> = uiState.asStateFlow()

    init {
        viewModelScope.launch {
            uiState.emit(UiState.Success(getUniversityDetailsUseCase(name)))
        }
    }
}