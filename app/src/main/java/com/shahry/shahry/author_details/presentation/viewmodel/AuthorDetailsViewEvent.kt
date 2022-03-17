package com.shahry.shahry.author_details.presentation.viewmodel

 import com.shahry.shahry.base.presentation.viewmodel.ViewEvent

sealed class AuthorDetailsViewEvent :ViewEvent {
    object ShowLoading : AuthorDetailsViewEvent()
    object HideLoading : AuthorDetailsViewEvent()
    data class PostsFailure(val errorMessageId:Int):AuthorDetailsViewEvent()
}