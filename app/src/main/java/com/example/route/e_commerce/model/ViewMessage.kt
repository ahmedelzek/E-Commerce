package com.example.route.e_commerce.model

data class ViewMessage(
    var title: String? = null,
    var message: String? = null,
    var posButtonTitle: String? = null,
    var negButtonTitle: String? = null,
    var onPosButtonClick: (() -> Unit)? = null,
    var onNegButtonClick: (() -> Unit)? = null
)
