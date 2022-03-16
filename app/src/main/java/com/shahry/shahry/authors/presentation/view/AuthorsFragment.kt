package com.shahry.shahry.authors.presentation.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.shahry.shahry.R
import com.shahry.shahry.authors.data.models.Author
import com.shahry.shahry.authors.presentation.viewmodel.*
import com.shahry.shahry.base.presentation.ui.BaseFragment
import com.shahry.shahry.databinding.FragmentAuthresBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorsFragment :
    BaseFragment<FragmentAuthresBinding, AuthorsViewState, AuthorsViewEvent, AuthorsAction, AuthorsResult>(
        R.layout.fragment_authres
    ), AuthorsClickListener {
    override val viewModel: AuthorsVieModel by viewModels()
    private val authorsAdapter = AuthorsAdapter(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.authorsRv.adapter = authorsAdapter
        initViewEvents {
            when (it) {
                AuthorsViewEvent.HideLoading -> dataBinding.loadingProgress.visibility = View.GONE
                AuthorsViewEvent.ShowLoading -> dataBinding.loadingProgress.visibility =
                    View.VISIBLE
            }
        }
    }

    override fun handleViewState(state: AuthorsViewState) {
        authorsAdapter.setData(state.authorsList ?: ArrayList())
    }

    override fun onAuthorClicked(author: Author) {
        TODO("Not yet implemented")
    }


}