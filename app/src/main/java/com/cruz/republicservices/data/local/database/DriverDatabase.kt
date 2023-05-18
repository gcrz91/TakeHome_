package com.cruz.republicservices.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cruz.republicservices.data.local.dao.DriverDao
import com.cruz.republicservices.data.local.dao.RouteDao
import com.cruz.republicservices.data.local.entity.DriverEntity
import com.cruz.republicservices.data.local.entity.RouteEntity
import com.cruz.republicservices.helper.DRIVER_DB_NAME
import com.cruz.republicservices.helper.DRIVER_DB_VERSION

@Database(entities = [DriverEntity::class, RouteEntity::class], version = DRIVER_DB_VERSION)
abstract class DriverDatabase : RoomDatabase() {
    abstract fun driverDao(): DriverDao
    abstract fun routeDao(): RouteDao

    companion object {
        fun create(context: Context): DriverDatabase {
            return Room.databaseBuilder(
                context = context.applicationContext,
                klass = DriverDatabase::class.java,
                name = DRIVER_DB_NAME
            ).build()
        }
    }
}
