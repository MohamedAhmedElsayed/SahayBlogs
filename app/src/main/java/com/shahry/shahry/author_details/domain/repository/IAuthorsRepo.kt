package com.shahry.shahry.author_details.domain.repository

import com.shahry.shahry.author_details.data.model.AuthorPost
import com.shahry.shahry.base.remote.NetworkResponse

interface IAuthorDetailsRepo {
    suspend fun loadAuthorPosts(id: String): NetworkResponse<ArrayList<AuthorPost>?>
}