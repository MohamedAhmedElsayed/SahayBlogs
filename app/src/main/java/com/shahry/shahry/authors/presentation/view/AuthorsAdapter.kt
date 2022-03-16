package com.shahry.shahry.authors.presentation.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.shahry.shahry.R
import com.shahry.shahry.authors.data.models.Author
import com.shahry.shahry.base.binding.loadImage
import com.shahry.shahry.base.presentation.ui.CustomRecyclerViewAdapter
import com.shahry.shahry.databinding.AuthorItemBinding
import java.util.*
import kotlin.collections.ArrayList


class AuthorsAdapter(private val listener: AuthorsClickListener) :
    CustomRecyclerViewAdapter<Author>() {
    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        return DataBindingUtil.bind(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.author_item, parent, false)
        )!!
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        val authrorInfo = getItem(position)
        val locationBinding = binding as AuthorItemBinding
        authrorInfo?.let {
            locationBinding.authorNameTv.text = authrorInfo.name
            locationBinding.authorEmailTv.text = it.email
            locationBinding.authorImage.loadImage(
                it.avatarUrl,
                placeholderDrawable = getImageDrawable(binding.root.context),
                errorDrawable = getImageDrawable(binding.root.context)
            )
        }
        binding.root.setOnClickListener {
            listener.onAuthorClicked(authrorInfo)
        }
    }

    private fun getImageDrawable(context: Context) = AppCompatResources.getDrawable(
        context,
        R.drawable.place_holder_image
    )


    fun setData(newData: ArrayList<Author>) {
        submitList(newData)
    }
}

interface AuthorsClickListener {
    fun onAuthorClicked(author: Author)
}
 