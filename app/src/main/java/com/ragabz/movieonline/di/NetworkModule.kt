package com.ragabz.movieonline.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ragabz.movieonline.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val TIME_OUT = 2L
private const val CHUCKER_MAX_CONTENT = 250000L

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    /**
     * provide HttploggingInterceptor
     */
    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    /**
     * provide OkHttpClient
     */
    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        chuckerInterceptor: ChuckerInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(chuckerInterceptor)
                addInterceptor(loggingInterceptor)
            }
            connectTimeout(TIME_OUT, TimeUnit.MINUTES)
            readTimeout(TIME_OUT, TimeUnit.MINUTES)
            writeTimeout(TIME_OUT, TimeUnit.MINUTES)
            retryOnConnectionFailure(true)
        }.build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .create()
    }

    /**
     * provide retrofit
     */
    @Provides
    @Singleton
    fun provideRetrofit(
        gson: Gson,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    /**
     * provide chucker interceptor
     */
    @Provides
    @Singleton
    fun provideChuckerInterceptor(@ApplicationContext context: Context): ChuckerInterceptor {
        return ChuckerInterceptor.Builder(context)
            .collector(ChuckerCollector(context))
            .maxContentLength(CHUCKER_MAX_CONTENT)
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(false)
            .build()
    }
}
