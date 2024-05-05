package com.abdulmohsen.universities.data.mapper

import com.abdulmohsen.local.model.UniversityInfo
import com.abdulmohsen.network.dto.UniversityDto
import com.abdulmohsen.universities.domain.model.University

internal fun List<UniversityDto>?.toDomainModel(): List<University> = this?.map {
    University(
        alphaTwoCode = it.alphaTwoCode.orEmpty(),
        country = it.country.orEmpty(),
        domains = it.domains.orEmpty(),
        name = it.name.orEmpty(),
        stateProvince = it.stateProvince.orEmpty(),
        webPages = it.webPages.orEmpty()
    )
}.orEmpty()

internal fun List<UniversityDto>.toDataModel():List<UniversityInfo> = this.map {
    UniversityInfo(
        alphaTwoCode = it.alphaTwoCode.orEmpty(),
        name = it.name.orEmpty(),
        country = it.country.orEmpty(),
        domains = it.domains.orEmpty(),
        webPages = it.webPages.orEmpty(),
        stateProvince = it.stateProvince.orEmpty()
    )
}

internal fun List<UniversityInfo>.toUniversityDomainModel(): List<University> = this.map {
    University(
        alphaTwoCode = it.alphaTwoCode,
        country = it.country,
        domains = it.domains,
        name = it.name,
        stateProvince = it.stateProvince,
        webPages = it.webPages
    )
}