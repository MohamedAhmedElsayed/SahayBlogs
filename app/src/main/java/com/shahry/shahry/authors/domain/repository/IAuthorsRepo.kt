package com.shahry.shahry.authors.domain.repository

import com.shahry.shahry.authors.data.models.Author

interface IAuthorsRepo {
    suspend fun loadAuthors(): ArrayList<Author>?
}