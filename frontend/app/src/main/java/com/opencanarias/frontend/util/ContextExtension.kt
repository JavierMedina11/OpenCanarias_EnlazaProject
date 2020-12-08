package com.retrofitP.loginimplementation.util

import android.content.Context
import android.os.Message
import android.widget.Toast

fun Context.toast(message: CharSequence) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}