package com.cruz.republicservices.di

import com.cruz.republicservices.data.local.dao.DriverDao
import com.cruz.republicservices.data.local.dao.RouteDao
import com.cruz.republicservices.data.remote.client.DriverService
import com.cruz.republicservices.data.repository.DriverRepository
import com.cruz.republicservices.data.repository.IDriverRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesDriverRepository(
        driverService: DriverService,
        driverDao: DriverDao,
        routeDao: RouteDao
    ): IDriverRepository {
        return DriverRepository(driverService, driverDao, routeDao)
    }
}
