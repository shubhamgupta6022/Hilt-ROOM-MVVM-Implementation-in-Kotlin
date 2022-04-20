package com.example.hilt.utils


import android.content.Context
import android.widget.Toast

fun toast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}