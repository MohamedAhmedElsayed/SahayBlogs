package com.shahry.shahry.authors.di

import com.shahry.shahry.authors.data.local.AuthorLocalDataSource
import com.shahry.shahry.authors.data.local.AuthorLocalDataSourceImp
import com.shahry.shahry.authors.data.remote.datasource.AuthorsRemoteDataSourceImp
import com.shahry.shahry.authors.data.remote.datasource.IAuthorsRemoteDataSource
import com.shahry.shahry.authors.data.repository.AuthorsRepositoryImp
import com.shahry.shahry.authors.domain.repository.IAuthorsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class AuthorsModule {
    @Binds
    abstract fun bindsAuthorsRepo(repositoryImp: AuthorsRepositoryImp): IAuthorsRepo

    @Binds
    abstract fun bindsAuthorRemoteDataSource(authorsRemoteDataSource: AuthorsRemoteDataSourceImp):
            IAuthorsRemoteDataSource

    @Binds
    abstract fun bindsAuthorLocalDataSource(authorLocalDataSourceImp: AuthorLocalDataSourceImp):
            AuthorLocalDataSource
}
