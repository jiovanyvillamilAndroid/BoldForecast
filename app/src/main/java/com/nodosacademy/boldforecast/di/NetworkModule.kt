package com.nodosacademy.boldforecast.di

import com.nodosacademy.boldforecast.BuildConfig
import com.nodosacademy.boldforecast.Constants.BASE_URL
import com.nodosacademy.boldforecast.Constants.QUERY_PARAM_KEY
import com.nodosacademy.boldforecast.network.NetworkDataSource
import com.nodosacademy.boldforecast.network.retrofit.ApiService
import com.nodosacademy.boldforecast.network.retrofit.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val url = chain
                    .request()
                    .url
                    .newBuilder()
                    .addQueryParameter(QUERY_PARAM_KEY, BuildConfig.TEST_API_KEY)
                    .build()
                chain.proceed(chain.request().newBuilder().url(url).build())
            }
            .build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()


    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun providesNetworkDataSource(apiService: ApiService) : NetworkDataSource = RetrofitClient(apiService)
}