package com.abdulmohsen.details.data.repository

import com.abdulmohsen.details.data.mapper.toDomainModel
import com.abdulmohsen.local.database.UniversitiesDao
import com.abdulmohsen.details.domain.model.UniversityDetails
import com.abdulmohsen.details.domain.repository.UniversityDetailsRepository

class UniversityDetailsRepositoryImpl(
    private val universitiesDao: UniversitiesDao
) : UniversityDetailsRepository {
    override suspend fun getUniversityDetails(name: String): UniversityDetails =
        universitiesDao.getUniversityDetails(name)
            .toDomainModel()
}