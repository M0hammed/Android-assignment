package com.abdulmohsen.universities.domain.usecase

import com.abdulmohsen.universities.domain.model.University
import com.abdulmohsen.universities.domain.repository.UniversitiesRepository

class GetUniversitiesListUseCase (
    private val universitiesRepository: UniversitiesRepository
) {
    suspend operator fun invoke(): Result<List<University>> = universitiesRepository.getUniversities()
}