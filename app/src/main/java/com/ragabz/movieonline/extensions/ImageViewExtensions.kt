package com.ragabz.movieonline.extensions

import android.graphics.Color
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.ragabz.movieonline.R
import java.util.*

fun ImageView.loadImageFromUrl(imageUrl: String?) {
    // create request options to set placeholder or error

    val circularProgressDrawable = CircularProgressDrawable(this.context).apply {
        strokeWidth = 5f
        centerRadius = 30f
        start()
    }
    val options = RequestOptions()
        .placeholder(circularProgressDrawable)
        .error(R.color.white)

    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(imageUrl ?: "")
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}

fun ImageView.bindRandomColor() {
    this.setBackgroundColor(getRandomColor())
}

fun getRandomColor(): Int {
    val rnd = Random()
    return Color.argb(
        255,
        rnd.nextInt(256),
        rnd.nextInt(256),
        rnd.nextInt(256)
    )
}
