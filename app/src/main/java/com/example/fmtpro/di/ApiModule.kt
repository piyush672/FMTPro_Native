package com.example.fmtpro.di

import android.content.Context
import com.example.fmtpro.ApiUrlProvider
import com.example.fmtpro.api.AuthenticationApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {
    @Singleton
    @Provides
    fun provideApiServiceObj(@ApplicationContext context: Context): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ApiUrlProvider.getApiBaseUrl(context))
            .build()
    }


    @Provides
    fun getApiService(retrofit: Retrofit): AuthenticationApi{
        return retrofit.create(AuthenticationApi::class.java)
    }
}