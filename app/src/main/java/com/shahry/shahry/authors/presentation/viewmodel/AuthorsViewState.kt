package com.shahry.shahry.authors.presentation.viewmodel

import com.shahry.shahry.authors.data.models.Author
import com.shahry.shahry.base.presentation.viewmodel.ViewState

data class AuthorsViewState constructor(val authorsList: ArrayList<Author>? = arrayListOf()) :
    ViewState