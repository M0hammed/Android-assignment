package com.abdulmohsen.network.service.universty

import com.abdulmohsen.network.dto.UniversityDto
import retrofit2.Response
import retrofit2.http.GET

interface UniversitiesListApi {

    @GET("search?country=United%20Arab%20Emirates")
    suspend fun getUniversities(): Response<List<UniversityDto>>
}