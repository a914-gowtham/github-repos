package com.gowtham.githubrepos.di

import com.gowtham.core.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDummyValue(): Int {
        return 22
    }


    @Provides
    @Singleton
    fun provideLogger(): Logger {
        return Logger(
            tag = "AppDebug",
            isDebug = true
        )
    }

}