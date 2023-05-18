package com.cruz.republicservices.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "route")
data class RouteEntity(
    @PrimaryKey
    val id: Int,
    val type: String,
    val name: String
)
