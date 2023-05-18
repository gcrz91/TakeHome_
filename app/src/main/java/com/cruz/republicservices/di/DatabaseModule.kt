package com.cruz.republicservices.di

import android.content.Context
import com.cruz.republicservices.data.local.dao.DriverDao
import com.cruz.republicservices.data.local.dao.RouteDao
import com.cruz.republicservices.data.local.database.DriverDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDriverDatabase(@ApplicationContext context: Context): DriverDatabase {
        return DriverDatabase.create(context)
    }

    @Provides
    @Singleton
    fun providesDriverDao(database: DriverDatabase): DriverDao {
        return database.driverDao()
    }

    @Provides
    @Singleton
    fun providesRouteDao(database: DriverDatabase): RouteDao {
        return database.routeDao()
    }
}
