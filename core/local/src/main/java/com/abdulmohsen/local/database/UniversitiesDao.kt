package com.abdulmohsen.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.abdulmohsen.local.model.UniversityInfo

@Dao
interface UniversitiesDao {
    @Transaction
    @Query("SELECT * FROM universities")
    suspend fun getAllUniversities(): List<UniversityInfo>

    @Transaction
    @Query("SELECT * FROM universities WHERE name= :name LIMIT 1")
    suspend fun getUniversityDetails(name: String): UniversityInfo

    @Transaction
    suspend fun updateUniversities(universities: List<UniversityInfo>) {
        clear()
        insertUniversityList(universities)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUniversityList(universities: List<UniversityInfo>)

    @Query("DELETE FROM universities")
    suspend fun clear()
}