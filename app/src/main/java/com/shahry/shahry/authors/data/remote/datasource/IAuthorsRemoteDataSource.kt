package com.shahry.shahry.authors.data.remote.datasource

import com.shahry.shahry.authors.data.models.Author
import com.shahry.shahry.base.remote.NetworkRemoteServiceCall
import com.shahry.shahry.base.remote.NetworkResponse

interface IAuthorsRemoteDataSource : NetworkRemoteServiceCall {
    suspend fun loadAuthors(): NetworkResponse<ArrayList<Author>?>
}