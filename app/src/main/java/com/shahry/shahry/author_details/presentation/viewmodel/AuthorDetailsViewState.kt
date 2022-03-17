package com.shahry.shahry.author_details.presentation.viewmodel

import com.shahry.shahry.author_details.data.model.AuthorPost
import com.shahry.shahry.base.presentation.viewmodel.ViewState

data class AuthorDetailsViewState constructor(val posts: ArrayList<AuthorPost> = arrayListOf()) :
    ViewState