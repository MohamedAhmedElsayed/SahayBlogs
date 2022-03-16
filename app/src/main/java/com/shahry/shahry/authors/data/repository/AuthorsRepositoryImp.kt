package com.shahry.shahry.authors.data.repository

import com.shahry.shahry.authors.data.models.Author
import com.shahry.shahry.authors.data.remote.datasource.IAuthorsRemoteDataSource
import com.shahry.shahry.authors.domain.repository.IAuthorsRepo
import com.shahry.shahry.base.remote.NetworkResponse
import javax.inject.Inject

class AuthorsRepositoryImp @Inject constructor(private val authorsRemoteDataSource: IAuthorsRemoteDataSource) :
    IAuthorsRepo {
    override suspend fun loadAuthors(): ArrayList<Author>? {
        val reponse = authorsRemoteDataSource.loadAuthors()
        if (reponse is NetworkResponse.Success) {
            return reponse.data
        }
        return null
    }
}