package com.example.route.e_commerce

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout


@BindingAdapter("error")
fun setErrorTextInputLayout(textInputLayout: TextInputLayout, errorText: String?) {
    textInputLayout.error = errorText
}