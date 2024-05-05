package com.abdulmohsen.details.domain.model

data class UniversityDetails(
    val alphaTwoCode: String = "",
    val country: String = "",
    val domains: List<String> = emptyList(),
    val name: String = "",
    val stateProvince: String = "",
    val webPages: List<String> = emptyList()
)
