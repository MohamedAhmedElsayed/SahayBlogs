package com.shahry.shahry.author_details.data.remote.datasource

import com.shahry.shahry.author_details.data.model.AuthorPost
import com.shahry.shahry.authors.data.models.Author
import com.shahry.shahry.base.remote.NetworkRemoteServiceCall
import com.shahry.shahry.base.remote.NetworkResponse

interface IAuthorsDetailsRemoteDataSource: NetworkRemoteServiceCall {
    suspend fun loadAuthorPosts(authorId:String): NetworkResponse<ArrayList<AuthorPost>?>
}