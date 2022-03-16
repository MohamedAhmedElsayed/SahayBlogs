package com.shahry.shahry.base.binding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

@BindingAdapter(
    value = [
        "ImgUrl",
        "placeholderImage",
        "errorImage",
        "fallbackImage",
        "skipMemoryCache",
        "skipDiskCache",
        "circularImage",
    ], requireAll = false
)
fun AppCompatImageView.loadImage(
    imageUrl: String?,
    placeholderDrawable: Drawable? = null,
    errorDrawable: Drawable? = null,
    fallbackDrawable: Drawable? = null,
    skipMemoryCache: Boolean = false,
    skipDiskCache: Boolean = false,
    isCircularImage: Boolean = false
) {

    val imageLoader = Glide.with(context)
        .load(imageUrl)
        .placeholder(placeholderDrawable)
        .error(errorDrawable)
        .fallback(fallbackDrawable)

    if (isCircularImage) imageLoader.apply(RequestOptions().circleCrop())

    if (skipDiskCache) imageLoader.diskCacheStrategy(DiskCacheStrategy.NONE)

    if (skipMemoryCache) imageLoader.skipMemoryCache(true)

    imageLoader.into(this)
}


@BindingAdapter("android:src")
fun AppCompatImageView.setResourceBindingAdapter(@DrawableRes resource: Int) {
    setImageResource(resource)
}