package com.shahry.shahry.authors.data.remote.apis

import com.shahry.shahry.authors.data.models.Author
import com.shahry.shahry.base.remote.CloudConfig
import retrofit2.Response
import retrofit2.http.GET

interface AuthorsApis {
    @GET(CloudConfig.AUTHORS)
    suspend fun loadAuthors(): Response<ArrayList<Author>?>
}