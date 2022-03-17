package com.shahry.shahry.authors.presentation.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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
    private var authorsAdapter: AuthorsAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authorsAdapter = AuthorsAdapter(this)
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
        authorsAdapter?.setData(state.authorsList ?: ArrayList())
    }

    override fun onAuthorClicked(author: Author) {
        val action = AuthorsFragmentDirections.toAuthorDetails(author)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        authorsAdapter = null
    }

}