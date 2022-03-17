package com.shahry.shahry.author_details.presentation.viewmodel

import com.shahry.shahry.author_details.data.model.AuthorPost
import com.shahry.shahry.base.presentation.viewmodel.Result

sealed class AuthorDetailsResult : Result {
    data class SuccessLoadingAuthorPosts(private val posts: ArrayList<AuthorPost>) :
        AuthorDetailsResult()

    data class FailureLoadingAuthorPosts(private val errorMessage: Int) : AuthorDetailsResult()
}