package com.gowtham.githubrepos.di

import android.app.Application
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoUseCasesModule {

    @Provides
    @Singleton
    @Named("githubAndroidSqlDriver") // in case you had another SQL Delight db
    fun provideAndroidDriver(app: Application): SqlDriver {
        return AndroidSqliteDriver(
            schema = HeroInteractors.schema,
            context = app,
            name = HeroInteractors.dbName
        )
    }

}