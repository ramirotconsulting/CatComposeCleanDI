package com.ramiro.krogerbenchlc.di

import com.ramiro.krogerbenchlc.data.repository.CatsRepository
import com.ramiro.krogerbenchlc.data.repository.CatsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun providesRepository(catsRepositoryImpl: CatsRepositoryImpl): CatsRepository
}