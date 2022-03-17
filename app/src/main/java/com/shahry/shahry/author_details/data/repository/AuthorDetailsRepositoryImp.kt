package com.shahry.shahry.author_details.data.repository

import com.shahry.shahry.author_details.data.remote.datasource.IAuthorsDetailsRemoteDataSource
import com.shahry.shahry.author_details.domain.repository.IAuthorDetailsRepo
 import javax.inject.Inject

class AuthorDetailsRepositoryImp @Inject constructor(
    private val authorDetailsRemoteDataSource: IAuthorsDetailsRemoteDataSource
) : IAuthorDetailsRepo {
    override suspend fun loadAuthorPosts(id: String) =
        authorDetailsRemoteDataSource.loadAuthorPosts(id)


}