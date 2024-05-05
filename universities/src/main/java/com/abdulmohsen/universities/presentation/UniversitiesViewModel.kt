package com.abdulmohsen.universities.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdulmohsen.common.UiState
import com.abdulmohsen.universities.domain.model.University
import com.abdulmohsen.universities.domain.usecase.GetUniversitiesListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UniversitiesViewModel(
    private val getUniversitiesListUseCase: GetUniversitiesListUseCase
) : ViewModel() {
    private val uiState: MutableStateFlow<UiState<List<University>>> =
        MutableStateFlow(UiState.Loading())
    val uiStateflow: StateFlow<UiState<List<University>>> = uiState.asStateFlow()

    init {
        refreshUniversities()
    }

    fun refreshUniversities() {
        viewModelScope.launch {
            viewModelScope.launch {
                getUniversitiesListUseCase()
                    .onSuccess {
                        uiState.emit(UiState.Success(it))
                    }
                    .onFailure {
                        uiState.emit(UiState.Error())
                    }
            }
        }
    }
}