package com.example.newappretrofittest.di

import com.example.newappretrofittest.data.remote.ImageApi
import com.example.newappretrofittest.repository.ImageRepository
import com.example.newappretrofittest.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideImageRepository(
        api: ImageApi
    ) = ImageRepository(api)

    @Singleton
    @Provides
    fun provideImageApi(): ImageApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ImageApi::class.java)
    }
}