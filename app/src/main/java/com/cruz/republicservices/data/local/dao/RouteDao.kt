package com.cruz.republicservices.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cruz.republicservices.data.local.entity.RouteEntity

@Dao
interface RouteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoutes(drivers: List<RouteEntity>)

    @Query("SELECT * FROM route")
    suspend fun getRoutes(): List<RouteEntity>
}
