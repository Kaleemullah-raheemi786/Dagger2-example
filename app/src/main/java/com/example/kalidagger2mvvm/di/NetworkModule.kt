package com.example.kalidagger2mvvm.di

import com.example.kalidagger2mvvm.models.util.Constants
import com.example.kalidagger2mvvm.retrofit.FakerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@DisableInstallInCheck
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideFakerApi(retrofit: Retrofit): FakerApi{
        return retrofit.create(FakerApi::class.java)
    }
}