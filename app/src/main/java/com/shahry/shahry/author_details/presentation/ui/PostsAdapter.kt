package com.shahry.shahry.author_details.presentation.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.shahry.shahry.R
import com.shahry.shahry.author_details.data.model.AuthorPost
import com.shahry.shahry.base.binding.loadImage
import com.shahry.shahry.base.presentation.ui.CustomRecyclerViewAdapter
import com.shahry.shahry.databinding.PostItemBinding

class PostsAdapter : CustomRecyclerViewAdapter<AuthorPost>() {
    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        return DataBindingUtil.bind(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.post_item, parent, false)
        )!!
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        val post = getItem(position)
        val locationBinding = binding as PostItemBinding
        post.let {
            locationBinding.authorTitleTv.text = it.title
            locationBinding.postBodyTv.text = it.body
            locationBinding.postImage.loadImage(
                it.imageUrl,
                placeholderDrawable = getImageDrawable(binding.root.context),
                errorDrawable = getImageDrawable(binding.root.context)
            )

        }

    }


    private fun getImageDrawable(context: Context) = AppCompatResources.getDrawable(
        context,
        R.drawable.place_holder_image
    )


    fun setData(newData: ArrayList<AuthorPost>) {
        submitList(newData)
    }
}
