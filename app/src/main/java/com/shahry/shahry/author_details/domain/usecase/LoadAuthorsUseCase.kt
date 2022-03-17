package com.shahry.shahry.author_details.domain.usecase

import com.shahry.shahry.author_details.data.remote.datasource.IAuthorsDetailsRemoteDataSource
import com.shahry.shahry.author_details.presentation.viewmodel.AuthorDetailsResult
import com.shahry.shahry.base.domain.SafeSuspendableUseCase
import com.shahry.shahry.base.remote.NetworkResponse
import javax.inject.Inject

class LoadAuthorPostsUseCase @Inject constructor(private val authorsDetailsRemoteDataSource: IAuthorsDetailsRemoteDataSource) :
    SafeSuspendableUseCase<String, AuthorDetailsResult> {
    override suspend fun execute(input: String): AuthorDetailsResult {
        return when (val response = authorsDetailsRemoteDataSource.loadAuthorPosts(input)) {
            is NetworkResponse.Failure -> AuthorDetailsResult.FailureLoadingAuthorPosts(response.errorMessageResId)
            is NetworkResponse.Success -> AuthorDetailsResult.SuccessLoadingAuthorPosts(
                response.data ?: arrayListOf()
            )
        }
    }
}