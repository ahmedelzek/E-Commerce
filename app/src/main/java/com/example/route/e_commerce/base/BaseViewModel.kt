package com.example.route.e_commerce.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.route.e_commerce.ui.model.ViewMessage

open class BaseViewModel : ViewModel() {
    var isLoadingLiveData = MutableLiveData<Boolean>()
    var viewMessageLiveData = MutableLiveData<ViewMessage>()
}