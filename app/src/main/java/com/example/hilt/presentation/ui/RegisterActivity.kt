package com.example.hilt.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.hilt.R
import com.example.hilt.databinding.ActivityRegisterBinding
import com.example.hilt.core.model.User
import com.example.hilt.presentation.viewmodel.UserViewModel
import com.example.hilt.core.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    @Inject
    lateinit var viewModelFactory: UserViewModel.UserViewModelFactory
    private val userViewModel: UserViewModel by viewModels {
        UserViewModel.providesFactory(
            viewModelFactory,
            "ID"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        binding.textViewLoginNow.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
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
        toast(this, "Success")

        startActivity(Intent(this, MainActivity::class.java))
    }
}