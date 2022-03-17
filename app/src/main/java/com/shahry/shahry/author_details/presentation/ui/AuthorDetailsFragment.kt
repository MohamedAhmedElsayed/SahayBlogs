package com.shahry.shahry.author_details.presentation.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.shahry.shahry.R
import com.shahry.shahry.author_details.presentation.viewmodel.*
import com.shahry.shahry.base.binding.loadImage
import com.shahry.shahry.base.presentation.ui.BaseFragment
import com.shahry.shahry.databinding.FragmentAutorDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class AuthorDetailsFragment :
    BaseFragment<FragmentAutorDetailsBinding, AuthorDetailsViewState, AuthorDetailsViewEvent, AuthorDetailsAction, AuthorDetailsResult>(
        R.layout.fragment_autor_details
    ) {
    override val viewModel: AuthorDetailsViewModel by viewModels()
    private val args: AuthorDetailsFragmentArgs by navArgs()
    private val postsAdapter = PostsAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initViewsData()
        initViewsClickListeners()
        initViewEvents {
            when (it) {
                AuthorDetailsViewEvent.HideLoading -> dataBinding.loadingProgress.visibility =
                    View.GONE
                AuthorDetailsViewEvent.ShowLoading -> dataBinding.loadingProgress.visibility =
                    View.VISIBLE
                is AuthorDetailsViewEvent.PostsFailure -> Toast.makeText(
                    requireContext(),
                    getString(it.errorMessageId),
                    Toast.LENGTH_LONG
                ).show()

            }
        }
    }

    private fun initViews() {
        dataBinding.authorPostsRv.adapter = postsAdapter
    }

    private fun initViewsClickListeners() {
        dataBinding.auterDetailsHeader.locationFab.setOnClickListener {
            val uri: String =
                java.lang.String.format(
                    Locale.ENGLISH,
                    "geo:%f,%f",
                    args.author.address?.latitude,
                    args.author.address?.longitude
                )
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            requireContext().startActivity(intent)
        }
    }

    private fun initViewsData() {
        with(args.author) {
            dataBinding.auterDetailsHeader.apply {
                authorEmailTv.text = email
                authorImage.loadImage(avatarUrl)
                authorNameTv.text = name
                authorUserNameTv.text = userName

            }
        }
        args.author.id?.let {
            viewModel.dispatch(AuthorDetailsAction.LoadAuthorPosts(it))
        }
    }

    override fun handleViewState(state: AuthorDetailsViewState) {
      Log.e("AA","${state.posts.size}")
        postsAdapter.setData(state.posts)
    }
}