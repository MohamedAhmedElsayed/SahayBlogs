package com.shahry.shahry.authors.presentation.viewmodel

import com.shahry.shahry.authors.data.models.Author
import com.shahry.shahry.base.presentation.viewmodel.Result

sealed class AuthorsResult : Result {
    data class LoadedAuthorList(val authors: ArrayList<Author>?):AuthorsResult()
}