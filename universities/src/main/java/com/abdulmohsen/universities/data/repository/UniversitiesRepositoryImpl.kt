package com.abdulmohsen.universities.data.repository

import com.abdulmohsen.local.database.UniversitiesDao
import com.abdulmohsen.network.http.safeApiCall
import com.abdulmohsen.network.service.universty.UniversitiesListApi
import com.abdulmohsen.universities.data.mapper.toDataModel
import com.abdulmohsen.universities.data.mapper.toDomainModel
import com.abdulmohsen.universities.data.mapper.toUniversityDomainModel
import com.abdulmohsen.universities.domain.model.University
import com.abdulmohsen.universities.domain.repository.UniversitiesRepository
import javax.inject.Inject

class UniversitiesRepositoryImpl @Inject constructor(
    private val universitiesListApi: UniversitiesListApi,
    private val universitiesDao: UniversitiesDao
) : UniversitiesRepository {
    override suspend fun getUniversities(): Result<List<University>> {
        safeApiCall { universitiesListApi.getUniversities() }
            .map { it.toDomainModel() }
        return safeApiCall { universitiesListApi.getUniversities() }
            .fold(
                onSuccess = {
                    universitiesDao.updateUniversities(it.toDataModel())
                    Result.success(it.toDomainModel())
                },
                onFailure = {
                    val allUniversities = universitiesDao.getAllUniversities()
                    Result.success(allUniversities.toUniversityDomainModel())
                }
            )
    }
}