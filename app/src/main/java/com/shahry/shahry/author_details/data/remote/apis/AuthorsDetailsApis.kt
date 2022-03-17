package com.shahry.shahry.author_details.data.remote.apis

import com.shahry.shahry.author_details.data.model.AuthorPost
import com.shahry.shahry.authors.data.models.Author
import com.shahry.shahry.base.remote.CloudConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthorsDetailsApis {
    @GET(CloudConfig.POSTS)
    suspend fun loadAuthorPosts(@Query("authorId") authorId: String): Response<ArrayList<AuthorPost>?>
}