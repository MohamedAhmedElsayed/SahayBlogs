package com.shahry.shahry.author_details.data.remote.datasource

import com.shahry.shahry.author_details.data.model.AuthorPost
import com.shahry.shahry.author_details.data.remote.apis.AuthorsDetailsApis
import com.shahry.shahry.base.remote.NetworkResponse
import javax.inject.Inject

class AuthorDetailsRemoteDataSourceImp @Inject constructor(private val authorsDetailsApis: AuthorsDetailsApis) :
    IAuthorsDetailsRemoteDataSource {

    override suspend fun loadAuthorPosts(authorId: String): NetworkResponse<ArrayList<AuthorPost>?> {
        return safeApiCall { authorsDetailsApis.loadAuthorPosts(authorId) }
    }


}