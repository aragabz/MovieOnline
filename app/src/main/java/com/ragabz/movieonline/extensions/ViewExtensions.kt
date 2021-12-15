package com.ragabz.movieonline.extensions

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.onClick(action: () -> Unit) = setOnClickListener {
    action.invoke()
}

var View.visible
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

fun View.hide(gone: Boolean = true) {
    visibility = if (gone) View.GONE else View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}

/**
 * Transforms static java function Snackbar.make() to an extension function on View.
 */
fun View.createSnackBar(snackbarText: String, timeLength: Int = Snackbar.LENGTH_LONG): Snackbar {
    return Snackbar.make(
        this,
        snackbarText,
        timeLength
    )
}
