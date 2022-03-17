package com.shahry.shahry.author_details.presentation.ui

import androidx.fragment.app.viewModels
import com.shahry.shahry.R
import com.shahry.shahry.author_details.presentation.viewmodel.*
import com.shahry.shahry.base.presentation.ui.BaseFragment
import com.shahry.shahry.databinding.FragmentAutorDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorDetailsFragment :
    BaseFragment<FragmentAutorDetailsBinding, AuthorDetailsViewState, AuthorDetailsViewEvent, AuthorDetailsAction, AuthorDetailsResult>(
        R.layout.fragment_autor_details
    ) {
    override val viewModel: AuthorDetailsViewModel by viewModels()
    override fun handleViewState(state: AuthorDetailsViewState) {
    }
}