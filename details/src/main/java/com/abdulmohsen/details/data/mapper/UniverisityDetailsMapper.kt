package com.abdulmohsen.details.data.mapper

import com.abdulmohsen.local.model.UniversityInfo
import com.abdulmohsen.details.domain.model.UniversityDetails

fun UniversityInfo.toDomainModel() = UniversityDetails(
    alphaTwoCode = alphaTwoCode,
    country = country,
    domains = domains,
    name = name,
    stateProvince = stateProvince,
    webPages = webPages
)