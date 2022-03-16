package com.shahry.shahry.authors.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.shahry.shahry.R
import com.shahry.shahry.authors.presentation.viewmodel.*
import com.shahry.shahry.base.presentation.screen.BaseFragment
import com.shahry.shahry.databinding.FragmentAuthresBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorsFragment :
    BaseFragment<FragmentAuthresBinding, AuthorsViewState, AuthorsViewEvent, AuthorsAction, AuthorsResult>(
        R.layout.fragment_authres
    ) {
    override val viewModel: AuthorsVieModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewEvents {
            Log.e("AAA", it.toString())
        }
    }

    override fun handleViewState(state: AuthorsViewState) {
        Log.e("AAA", "size ${state.authorsList?.size}")
    }


}