package com.abdulmohsen.local.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.abdulmohsen.local.model.UniversityInfo

private const val DATABASE_NAME = "assessment_db"
private const val VERSION = 1

@Database(entities = [UniversityInfo::class], version = VERSION)
@TypeConverters(value = [ListTypeConverter::class])
abstract class UniversitiesDatabase : RoomDatabase() {
    abstract fun getAssessmentDao(): UniversitiesDao


    companion object {
        fun build(context: Application): UniversitiesDatabase = Room.databaseBuilder(
            context, UniversitiesDatabase::class.java, DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
}