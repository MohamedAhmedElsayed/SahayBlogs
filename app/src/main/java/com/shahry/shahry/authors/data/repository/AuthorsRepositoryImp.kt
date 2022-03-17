package com.shahry.shahry.authors.data.repository

import com.shahry.shahry.authors.data.local.AuthorLocalDataSource
import com.shahry.shahry.authors.data.models.Author
import com.shahry.shahry.authors.data.remote.datasource.IAuthorsRemoteDataSource
import com.shahry.shahry.authors.domain.repository.IAuthorsRepo
import com.shahry.shahry.base.remote.NetworkResponse
import javax.inject.Inject

class AuthorsRepositoryImp @Inject constructor(
    private val authorsRemoteDataSource: IAuthorsRemoteDataSource,
    private val authorLocalDataSource: AuthorLocalDataSource
) : IAuthorsRepo {
    override suspend fun loadAuthors(): ArrayList<Author>? {
        val reponse = authorsRemoteDataSource.loadAuthors()
        return if (reponse is NetworkResponse.Success) {
            reponse.data?.let {
                authorLocalDataSource.insertAuthors(it)
            }
            (reponse.data)
        } else {
            authorLocalDataSource.readAuthors()

        }
    }


}