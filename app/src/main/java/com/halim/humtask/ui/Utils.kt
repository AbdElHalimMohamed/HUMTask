package com.halim.humtask.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.TypedValue
import kotlin.reflect.KClass

fun Context.dp2Px(dp: Float): Float {
    val displayMetrics = resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
}

fun <T : Activity> Activity.startActivity(
    target: KClass<T>, key: String,
    parcelable: Parcelable, extraFlags: Int = -1
) {
    val bundle = Bundle()
    bundle.putParcelable(key, parcelable)
    startActivity(target, bundle, extraFlags)
}

fun <T : Activity> Activity.startActivity(
    target: KClass<T>, key: String,
    data: Long, extraFlags: Int = -1
) {
    val bundle = Bundle()
    bundle.putLong(key, data)
    startActivity(target, bundle, extraFlags)
}

fun <T : Activity> Activity.startActivity(
    target: KClass<T>, key: String,
    string: String,
    extraFlags: Int = -1
) {
    val bundle = Bundle()
    bundle.putString(key, string)
    startActivity(target, bundle, extraFlags)
}

fun <T : Activity> Activity.startActivity(
    target: KClass<T>,
    bundle: Bundle? = null,
    extraFlags: Int = -1
) {
    val intent = Intent(this, target.java)

    if (bundle != null) {
        intent.putExtras(bundle)
    }

    if (extraFlags != -1) {
        intent.addFlags(extraFlags)
    }

    startActivity(intent)
}