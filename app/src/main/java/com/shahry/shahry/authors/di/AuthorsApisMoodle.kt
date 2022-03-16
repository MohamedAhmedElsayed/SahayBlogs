package com.shahry.shahry.authors.di

import com.shahry.shahry.authors.data.remote.apis.AuthorsApis
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@InstallIn(ViewModelComponent::class)
@Module
object AuthorsApisMoodle {
    @Provides
    fun provideAuthorsApi(retrofit: Retrofit): AuthorsApis {
        return retrofit.create(AuthorsApis::class.java)
    }
}