package com.abdulmohsen.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "universities")
data class UniversityInfo(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo("alphaTwoCode")
    val alphaTwoCode: String,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("country")
    val country: String,
    @ColumnInfo("domains")
    val domains: List<String>,
    @ColumnInfo("webPages")
    val webPages: List<String>,
    @ColumnInfo("stateProvince")
    val stateProvince: String
)
