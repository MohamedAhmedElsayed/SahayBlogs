package com.shahry.shahry.authors.data.remote.datasource

import com.shahry.shahry.authors.data.models.Author
import com.shahry.shahry.authors.data.remote.apis.AuthorsApis
import com.shahry.shahry.base.remote.NetworkResponse
import javax.inject.Inject

class AuthorsRemoteDataSourceImp @Inject constructor(private val authorsApis: AuthorsApis) :
    IAuthorsRemoteDataSource {
    override suspend fun loadAuthors(): NetworkResponse<ArrayList<Author>?> {
        return safeApiCall { authorsApis.loadAuthors() }
    }
}