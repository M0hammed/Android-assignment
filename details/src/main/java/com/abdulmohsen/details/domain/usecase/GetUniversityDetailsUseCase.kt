package com.abdulmohsen.details.domain.usecase

import com.abdulmohsen.details.domain.repository.UniversityDetailsRepository

class GetUniversityDetailsUseCase(private val universityDetailsRepository: UniversityDetailsRepository) {

    suspend operator fun invoke(name: String) =
        universityDetailsRepository.getUniversityDetails(name)
}