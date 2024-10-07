package com.p20241004_amardhade_nycschools.data.di

import com.p20241004_amardhade_nycschools.data.ApiService
import com.p20241004_amardhade_nycschools.data.repos.AppRepoImpl
import com.p20241004_amardhade_nycschools.domain.repos.AppRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppDI {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://data.cityofnewyork.us/").addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideAppRepo(apiService: ApiService): AppRepo {
        return AppRepoImpl(apiService)
    }

}