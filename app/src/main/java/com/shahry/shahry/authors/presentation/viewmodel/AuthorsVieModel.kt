package com.shahry.shahry.authors.presentation.viewmodel

import com.shahry.shahry.authors.domain.usecase.LoadAuthorsUseCase
import com.shahry.shahry.base.presentation.viewmodel.NewBaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class AuthorsVieModel @Inject constructor(private val authorsUseCase: LoadAuthorsUseCase) :
    NewBaseViewModel<AuthorsViewState, AuthorsViewEvent, AuthorsAction, AuthorsResult>(
        AuthorsViewState()
    ) {
    init {
        dispatch(AuthorsAction.LoadAuthors)
    }

    override fun handle(action: AuthorsAction): Flow<AuthorsResult> = flow {
        when (action) {
            AuthorsAction.LoadAuthors -> {
                onViewEvent(AuthorsViewEvent.ShowLoading)
                emit(authorsUseCase.execute())
                onViewEvent(AuthorsViewEvent.HideLoading)
            }
        }
    }

    override fun reduce(result: AuthorsResult): AuthorsViewState {
        return when (result) {
            is AuthorsResult.LoadedAuthorList -> currentState.copy(authorsList = result.authors)
        }
    }
}