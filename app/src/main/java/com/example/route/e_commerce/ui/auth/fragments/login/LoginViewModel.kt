package com.example.route.e_commerce.ui.auth.fragments.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.route.e_commerce.base.BaseViewModel
import com.example.route.e_commerce.domain.usecases.LoginUseCase
import com.example.route.e_commerce.model.ViewMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private var loginUseCase: LoginUseCase) : BaseViewModel() {
    var emailLiveData = MutableLiveData("")
    var passwordLiveData = MutableLiveData("")
    var emailErrorLiveData = MutableLiveData<String?>()
    var passwordErrorLiveData = MutableLiveData<String?>()
    var events = MutableLiveData<LoginScreenEvents>()


    fun login() {
        if (!validate()) return
        viewModelScope.launch {
            isLoadingLiveData.value = true
            try {
                loginUseCase.execute(emailLiveData.value!!, passwordLiveData.value!!)
                isLoadingLiveData.value = false
                events.value = LoginScreenEvents.NavigateToHomeEvent
            } catch (e: Exception) {
                viewMessageLiveData.value = ViewMessage(
                    title = "Error",
                    message = e.localizedMessage
                )
                isLoadingLiveData.value = false
            }
        }
    }


    fun createOnClick() {
        events.value = LoginScreenEvents.NavigateToRegisterEvent
    }

    private fun validate(): Boolean {
        var isValid = true
        if (emailLiveData.value.isNullOrEmpty()) {
            emailErrorLiveData.value = "Please Enter Valid Email..!"
            isValid = false
        } else {
            emailErrorLiveData.value = null
        }
        if (passwordLiveData.value.isNullOrEmpty()) {
            passwordErrorLiveData.value = "Please Enter Valid Password..!"
            isValid = false
        } else {
            passwordErrorLiveData.value = null
        }
        return isValid
    }
}