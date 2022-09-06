package com.example.dipractice.di

import com.example.dipractice.domain.repository.MemeRepository
import com.example.dipractice.network.ApiInterface
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRetrofitInstance():Retrofit = Retrofit.Builder()
        .baseUrl("https://api.imgflip.com/")
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder()
                    .addLast(KotlinJsonAdapterFactory())
                    .build()
            )
        )
        .build()


    @Provides
    fun provideMemeApi(retrofit: Retrofit):ApiInterface = retrofit.create(ApiInterface::class.java)



    @Provides
    @Singleton
    fun provideMemeRepository(api: ApiInterface): MemeRepository = MemeRepository(api)
}