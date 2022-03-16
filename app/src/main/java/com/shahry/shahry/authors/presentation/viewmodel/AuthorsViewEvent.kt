package com.shahry.shahry.authors.presentation.viewmodel

import com.shahry.shahry.base.presentation.viewmodel.ViewEvent

sealed class AuthorsViewEvent : ViewEvent {
    object ShowLoading : AuthorsViewEvent()
    object HideLoading : AuthorsViewEvent()
}