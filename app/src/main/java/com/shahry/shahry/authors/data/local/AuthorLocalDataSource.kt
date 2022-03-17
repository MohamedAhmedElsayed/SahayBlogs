package com.shahry.shahry.authors.data.local

import com.shahry.shahry.authors.data.models.Author
import java.util.*

interface AuthorLocalDataSource {
    suspend fun insertAuthors(authers: ArrayList<Author>)
    suspend fun readAuthors(): ArrayList<Author>
}