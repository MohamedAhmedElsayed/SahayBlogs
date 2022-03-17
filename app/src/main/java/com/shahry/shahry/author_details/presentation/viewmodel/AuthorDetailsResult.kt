package com.shahry.shahry.author_details.presentation.viewmodel

import com.shahry.shahry.author_details.data.model.AuthorPost
import com.shahry.shahry.base.presentation.viewmodel.Result

sealed class AuthorDetailsResult : Result {
    data class SuccessLoadingAuthorPosts(  val posts: ArrayList<AuthorPost>) :
        AuthorDetailsResult()

    data class FailureLoadingAuthorPosts(  val errorMessage: Int) : AuthorDetailsResult()
}