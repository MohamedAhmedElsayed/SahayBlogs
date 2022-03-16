package com.shahry.shahry.authors.domain.usecase

import com.shahry.shahry.authors.domain.repository.IAuthorsRepo
import com.shahry.shahry.authors.presentation.viewmodel.AuthorsResult
import com.shahry.shahry.base.domain.SuspendableUseCase
import javax.inject.Inject

class LoadAuthorsUseCase @Inject constructor(private val authorsRepo: IAuthorsRepo) :
    SuspendableUseCase<Unit, AuthorsResult> {
    override suspend fun execute(input: Unit?): AuthorsResult.LoadedAuthorList {
        return AuthorsResult.LoadedAuthorList(authorsRepo.loadAuthors())
    }
}