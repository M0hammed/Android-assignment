package com.abdulmohsen.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UniversityDto(
    @Json(name = "alpha_two_code")
    val alphaTwoCode: String?,
    @Json(name = "country")
    val country: String?,
    @Json(name = "domains")
    val domains: List<String>?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "state-province")
    val stateProvince: String?,
    @Json(name = "web_pages")
    val webPages: List<String>?
)