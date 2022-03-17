package com.shahry.shahry.authors.di

import com.shahry.shahry.author_details.data.remote.datasource.AuthorDetailsRemoteDataSourceImp
import com.shahry.shahry.author_details.data.remote.datasource.IAuthorsDetailsRemoteDataSource
import com.shahry.shahry.author_details.data.repository.AuthorDetailsRepositoryImp
import com.shahry.shahry.author_details.domain.repository.IAuthorDetailsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class AuthorDetailsModule {
    @Binds
    abstract fun bindsAuthorDetailsRepo(repositoryImp: AuthorDetailsRepositoryImp): IAuthorDetailsRepo


    @Binds
    abstract fun bindsAuthorDetailsRemoteDataSource(authorDetailsRemoteDataSource: AuthorDetailsRemoteDataSourceImp): IAuthorsDetailsRemoteDataSource
}
