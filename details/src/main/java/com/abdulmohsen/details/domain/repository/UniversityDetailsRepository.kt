package com.abdulmohsen.details.domain.repository

import com.abdulmohsen.details.domain.model.UniversityDetails

interface UniversityDetailsRepository {
    suspend fun getUniversityDetails(name: String): UniversityDetails
}