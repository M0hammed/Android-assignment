package com.abdulmohsen.local.database

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class ListTypeConverter {
    @TypeConverter
    fun fromJson(json: String): List<String> {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        // Define type for List<String>
        val type = Types.newParameterizedType(List::class.java, String::class.java)

        // Create JsonAdapter for List<String>
        val adapter: JsonAdapter<List<String>> = moshi.adapter(type)

        // Deserialize JSON string to List<String>
        return adapter.fromJson(json).orEmpty()
    }

    @TypeConverter
    fun toJson(list: List<String>?): String {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        // Define type for List<String>
        val type = Types.newParameterizedType(List::class.java, String::class.java)

        // Create JsonAdapter for List<String>
        val adapter: JsonAdapter<List<String>> = moshi.adapter(type)

        // Serialize List<String> to JSON string
        return adapter.toJson(list)
    }
}