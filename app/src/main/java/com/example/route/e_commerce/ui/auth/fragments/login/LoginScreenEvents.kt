package com.example.route.e_commerce.ui.auth.fragments.login

sealed class LoginScreenEvents {
    data object NavigateToHomeEvent : LoginScreenEvents()
    data object NavigateToRegisterEvent : LoginScreenEvents()
}