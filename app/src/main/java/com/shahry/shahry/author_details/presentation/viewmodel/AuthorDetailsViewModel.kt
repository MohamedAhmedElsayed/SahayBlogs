package com.shahry.shahry.author_details.presentation.viewmodel

import android.util.Log
import com.shahry.shahry.author_details.domain.usecase.LoadAuthorPostsUseCase
import com.shahry.shahry.authors.presentation.viewmodel.AuthorsViewEvent
import com.shahry.shahry.base.presentation.viewmodel.NewBaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class AuthorDetailsViewModel @Inject constructor(private val loadAuthorPostsUseCase: LoadAuthorPostsUseCase) :
    NewBaseViewModel<AuthorDetailsViewState, AuthorDetailsViewEvent, AuthorDetailsAction, AuthorDetailsResult>(
        AuthorDetailsViewState()
    ) {
    override fun handle(action: AuthorDetailsAction): Flow<AuthorDetailsResult> = flow {
        when (action) {
            is AuthorDetailsAction.LoadAuthorPosts -> {
                onViewEvent(AuthorDetailsViewEvent.ShowLoading)
                val result = loadAuthorPostsUseCase.execute(action.id.toString())
                if (result is AuthorDetailsResult.FailureLoadingAuthorPosts) {
                    Log.e("AA", "error")
                    onViewEvent(AuthorDetailsViewEvent.PostsFailure(result.errorMessage))
                } else emit(result)
                onViewEvent(AuthorDetailsViewEvent.HideLoading)

            }
        }
    }

    override fun reduce(result: AuthorDetailsResult): AuthorDetailsViewState {
        return when (result) {
            is AuthorDetailsResult.SuccessLoadingAuthorPosts -> {
                Log.e("AA", "sucess ${result.posts.size}")
                currentState.copy(posts = result.posts)
            }

            else -> {
                currentState
            }
        }
    }
}