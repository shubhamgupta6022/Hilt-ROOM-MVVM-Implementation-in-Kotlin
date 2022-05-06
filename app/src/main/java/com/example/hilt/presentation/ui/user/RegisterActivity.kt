package com.example.hilt.presentation.ui.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.hilt.R
import com.example.hilt.databinding.ActivityRegisterBinding
import com.example.hilt.domain.model.User
import com.example.hilt.presentation.viewmodel.user.UserViewModel
import com.example.hilt.core.utils.toast
import com.example.hilt.presentation.ui.user.viewmodelfactory.UserViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    @Inject
    lateinit var viewModelFactory: UserViewModelFactory
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        userViewModel = ViewModelProvider(this, viewModelFactory)[UserViewModel::class.java]

        binding.textViewLoginNow.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.buttonRegister.setOnClickListener {
            register()
        }

    }

    private fun register() {
        userViewModel.insert(
            User(
                uid = 0,
                name = binding.editTextTextPersonName.text.toString(),
                emailId = binding.editTextTextEmailAddress.text.toString(),
                password = binding.editTextTextPassword.text.toString()
            )
        )
        toast(this@RegisterActivity, "Success")

        startActivity(Intent(this, LoginActivity::class.java))
    }
}