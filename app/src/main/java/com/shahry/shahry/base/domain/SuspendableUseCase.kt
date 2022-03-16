package com.shahry.shahry.base.domain

interface SuspendableUseCase<I, O> {

    suspend fun execute(input: I? = null): O
}

interface SafeSuspendableUseCase<I, O> {

    suspend fun execute(input: I): O
}