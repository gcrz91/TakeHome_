package com.cruz.republicservices.di

import com.cruz.republicservices.data.repository.IDriverRepository
import com.cruz.republicservices.domain.usecase.FetchDriversUseCase
import com.cruz.republicservices.domain.usecase.GetDriversUseCase
import com.cruz.republicservices.domain.usecase.GetRoutesForDriverUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun providesFetchDriversUseCase(driversRepository: IDriverRepository): FetchDriversUseCase {
        return FetchDriversUseCase(driversRepository)
    }

    @Provides
    fun providesGetDriversUseCase(driversRepository: IDriverRepository): GetDriversUseCase {
        return GetDriversUseCase(driversRepository)
    }

    @Provides
    fun providesGetRoutesDriversUseCase(
        driversRepository: IDriverRepository
    ): GetRoutesForDriverUseCase {
        return GetRoutesForDriverUseCase(driversRepository)
    }
}
