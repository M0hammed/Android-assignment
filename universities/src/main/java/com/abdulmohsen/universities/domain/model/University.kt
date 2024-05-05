package com.abdulmohsen.universities.domain.model

data class University(
    val alphaTwoCode: String = "",
    val country: String = "",
    val domains: List<String> = emptyList(),
    val name: String = "",
    val stateProvince: String = "",
    val webPages: List<String> = emptyList()
)
