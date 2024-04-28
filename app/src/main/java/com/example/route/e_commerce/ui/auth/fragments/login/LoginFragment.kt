package com.example.route.e_commerce.ui.auth.fragments.login

import android.content.Intent
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.route.e_commerce.R
import com.example.route.e_commerce.base.BaseFragment
import com.example.route.e_commerce.databinding.FragmentLoginBinding
import com.example.route.e_commerce.ui.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val viewModel: LoginViewModel by viewModels()

    override fun observeLiveData() {
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

    override fun getLayoutId(): Int = R.layout.fragment_login
}