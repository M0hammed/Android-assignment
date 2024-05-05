package com.abdulmohsen.details.presentation

import com.abdulmohsen.common.UiState
import com.abdulmohsen.details.domain.model.UniversityDetails
import com.abdulmohsen.details.domain.usecase.GetUniversityDetailsUseCase
import io.mockk.MockKAnnotations
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UniversityDetailsViewModelTest {
    private lateinit var objectUnderTest: UniversityDetailsViewModel

    @RelaxedMockK
    private lateinit var getUniversitiesListUseCase: GetUniversityDetailsUseCase

    @Before
    fun setup() {
        init(this)
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @Test
    fun `should return success when init`() = runTest {
        // Given
        coEvery { getUniversitiesListUseCase("") } returns UniversityDetails()
        createObjectUnderTest()

        // When
        // init

        // Then
        val state = objectUnderTest.uiStateflow.first()
        Assert.assertTrue(state is UiState.Success)
    }

    private fun createObjectUnderTest() {
        objectUnderTest = UniversityDetailsViewModel(getUniversitiesListUseCase, "")
    }
}