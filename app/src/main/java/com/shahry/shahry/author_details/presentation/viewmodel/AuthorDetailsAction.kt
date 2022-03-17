package com.shahry.shahry.author_details.presentation.viewmodel

import com.shahry.shahry.base.presentation.viewmodel.Action

sealed class AuthorDetailsAction : Action {
    data class LoadAuthorPosts (val id: Int) : AuthorDetailsAction()
}