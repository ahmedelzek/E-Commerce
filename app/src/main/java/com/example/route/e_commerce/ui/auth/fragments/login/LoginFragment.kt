package com.example.route.e_commerce.ui.auth.fragments.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.route.e_commerce.R
import com.example.route.e_commerce.base.BaseFragment
import com.example.route.e_commerce.databinding.FragmentLoginBinding
import com.example.route.e_commerce.ui.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }

    override fun observeToLiveData() {
        viewModel.events.observe(viewLifecycleOwner) {
            when (it) {
                LoginScreenEvents.NavigateToHomeEvent -> {
                    val intent = Intent(activity, HomeActivity::class.java)
                    startActivity(intent)
                    activity?.finish()
                }

                LoginScreenEvents.NavigateToRegisterEvent -> {
                    findNavController().navigate(R.id.action_loginFragment_to_registerFragment)

                }
            }
        }

    }

    override fun initViewModel(): LoginViewModel =
        ViewModelProvider(this)[LoginViewModel::class.java]


    override fun getLayoutId(): Int = R.layout.fragment_login
}