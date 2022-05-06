package com.example.hilt.presentation.ui.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.hilt.R
import com.example.hilt.databinding.ActivityLoginBinding
import com.example.hilt.presentation.viewmodel.user.UserViewModel
import com.example.hilt.core.utils.toast
import com.example.hilt.presentation.ui.profile.HomeActivity
import com.example.hilt.presentation.ui.user.viewmodelfactory.UserViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private var TAG = LoginActivity::class.simpleName

    @Inject
    lateinit var viewModelFactory: UserViewModelFactory
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        userViewModel = ViewModelProvider(this, viewModelFactory)[UserViewModel::class.java]

        binding.buttonLogin.setOnClickListener {
            login()
        }

        binding.textViewRegisterNow.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        lifecycleScope.launch(Dispatchers.IO) {
            userViewModel.usersList.collectLatest {
                Log.d(TAG, "$it")
            }
        }

    }

    private fun login() {
        val email = binding.editTextTextEmailAddress.text.toString()
        val password = binding.editTextTextPassword.text.toString()

        lifecycleScope.launch(Dispatchers.Main) {
            val uid = userViewModel.getUid(email, password)
            if (uid == null) {
                toast(this@LoginActivity, "Error")
            } else {
                Log.d("MainActivity", "uid: $uid")
                toast(this@LoginActivity, "uid: $uid")

                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)

            }
        }

    }
}