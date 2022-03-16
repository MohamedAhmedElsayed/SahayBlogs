package com.shahry.shahry.authors.presentation.viewmodel

import com.shahry.shahry.base.presentation.viewmodel.Action

sealed class AuthorsAction:Action {
    object LoadAuthors:AuthorsAction()
}