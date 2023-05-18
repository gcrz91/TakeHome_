package com.cruz.republicservices.di

import com.cruz.republicservices.data.remote.client.DriverService
import com.cruz.republicservices.data.remote.client.IRetrofitProvider
import com.cruz.republicservices.data.remote.client.RetrofitProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofitProvider(): IRetrofitProvider {
        return RetrofitProvider()
    }

    @Singleton
    @Provides
    fun returnsDriverService(retrofitProvider: IRetrofitProvider): DriverService {
        return retrofitProvider.retrofit.create(DriverService::class.java)
    }
}
