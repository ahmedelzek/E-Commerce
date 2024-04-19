package com.example.route.e_commerce.ui.auth.fragments.login

import androidx.lifecycle.ViewModelProvider
import com.example.route.e_commerce.R
import com.example.route.e_commerce.base.BaseFragment
import com.example.route.e_commerce.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>() {


    override fun initViewModel(): LoginViewModel =
        ViewModelProvider(this)[LoginViewModel::class.java]


    override fun getLayoutId(): Int = R.layout.fragment_login
}