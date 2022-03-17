package com.shahry.shahry.author_details.presentation.viewmodel

import com.shahry.shahry.author_details.domain.usecase.LoadAuthorPostsUseCase
import com.shahry.shahry.base.presentation.viewmodel.NewBaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class AuthorDetailsViewModel @Inject constructor(private val loadAuthorPostsUseCase: LoadAuthorPostsUseCase) :
    NewBaseViewModel<AuthorDetailsViewState, AuthorDetailsViewEvent, AuthorDetailsAction, AuthorDetailsResult>(
        AuthorDetailsViewState()
    ) {
    override fun handle(action: AuthorDetailsAction): Flow<AuthorDetailsResult> {
        TODO("Not yet implemented")
    }

    override fun reduce(result: AuthorDetailsResult): AuthorDetailsViewState {
        TODO("Not yet implemented")
    }
}