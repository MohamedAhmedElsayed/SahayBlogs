package com.shahry.shahry.authors.di

import com.shahry.shahry.author_details.data.remote.apis.AuthorsDetailsApis
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@InstallIn(ViewModelComponent::class)
@Module
object AuthorDetailsApisMoodle {
    @Provides
    fun provideAuthorPostsApi(retrofit: Retrofit): AuthorsDetailsApis {
        return retrofit.create(AuthorsDetailsApis::class.java)
    }
}