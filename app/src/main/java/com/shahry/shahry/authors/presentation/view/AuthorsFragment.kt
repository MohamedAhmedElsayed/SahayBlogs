package com.shahry.shahry.authors.presentation.view

import androidx.fragment.app.viewModels
import com.shahry.shahry.R
import com.shahry.shahry.authors.presentation.viewmodel.*
import com.shahry.shahry.base.ui.screen.BaseFragment
import com.shahry.shahry.databinding.FragmentAuthresBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorsFragment :
    BaseFragment<FragmentAuthresBinding, AuthorsViewState, AuthorsViewEvent, AuthorsAction, AuthorsResult>(
        R.layout.fragment_authres
    ) {
    override val viewModel: AuthorsVieModel by viewModels()

    override fun handleViewState(state: AuthorsViewState) {
    }


}