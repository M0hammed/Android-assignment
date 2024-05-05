package com.abdulmohsen.universities.presentation

import com.abdulmohsen.common.UiState
import com.abdulmohsen.universities.domain.usecase.GetUniversitiesListUseCase
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.coJustAwait
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class UniversitiesViewModelTest {

    private lateinit var objectUnderTest: UniversitiesViewModel

    @RelaxedMockK
    private lateinit var getUniversitiesListUseCase: GetUniversitiesListUseCase

    @Before
    fun setup() {
        init(this)
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @Test
    fun `Should emit Loading state when init`() = runTest {
        // Given
        coJustAwait { getUniversitiesListUseCase() }
        createObjectUnderTest()

        // When
        // init

        // Then
        val state = objectUnderTest.uiStateflow.first()
        assertTrue(state is UiState.Loading)
    }

    @Test
    fun `Should emit Error state when init and getUniversitiesListUseCase failed`() =
        runTest {
            // Given
            coEvery { getUniversitiesListUseCase() } returns Result.failure(Throwable())
            createObjectUnderTest()

            // When
            // init

            // Then
            val state = objectUnderTest.uiStateflow.first()
            assertTrue(state is UiState.Error)
        }

    @Test
    fun `Should emit Success state when init and getUniversitiesListUseCase success`() =
        runTest {
            // Given
            coEvery { getUniversitiesListUseCase() } returns Result.success(emptyList())
            createObjectUnderTest()

            // When
            // init

            // Then
            val state = objectUnderTest.uiStateflow.first()
            assertTrue(state is UiState.Success)
        }

    @Test
    fun `Should emit Error state when refresh and getUniversitiesListUseCase failed`() =
        runTest {
            // Given
            coEvery { getUniversitiesListUseCase() } returns Result.failure(Throwable())
            createObjectUnderTest()

            // When
            objectUnderTest.refreshUniversities()

            // Then
            val state = objectUnderTest.uiStateflow.first()
            assertTrue(state is UiState.Error)
        }

    @Test
    fun `Should emit Success state when refresh and getUniversitiesListUseCase success`() =
        runTest {
            // Given
            coEvery { getUniversitiesListUseCase() } returns Result.success(emptyList())
            createObjectUnderTest()

            // When
            objectUnderTest.refreshUniversities()

            // Then
            val state = objectUnderTest.uiStateflow.first()
            assertTrue(state is UiState.Success)
        }

    private fun createObjectUnderTest() {
        objectUnderTest = UniversitiesViewModel(getUniversitiesListUseCase)
    }
}