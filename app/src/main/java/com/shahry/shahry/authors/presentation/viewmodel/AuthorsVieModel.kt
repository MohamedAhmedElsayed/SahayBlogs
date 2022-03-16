package com.shahry.shahry.authors.presentation.viewmodel

import com.shahry.shahry.base.ui.viewmodel.NewBaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class AuthorsVieModel @Inject constructor() :
    NewBaseViewModel<AuthorsViewState, AuthorsViewEvent, AuthorsAction, AuthorsResult>(
        AuthorsViewState()
    ) {
    override fun handle(action: AuthorsAction): Flow<AuthorsResult> {
        TODO("Not yet implemented")
    }

    override fun reduce(result: AuthorsResult): AuthorsViewState {
        TODO("Not yet implemented")
    }
}