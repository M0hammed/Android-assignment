package com.abdulmohsen.universities.domain.repository

import com.abdulmohsen.universities.domain.model.University

interface UniversitiesRepository {
    suspend fun getUniversities(): Result<List<University>>
}