package com.example.hilt.presentation.ui.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.hilt.R
import com.example.hilt.databinding.ActivityMainBinding
import com.example.hilt.presentation.viewmodel.user.UserViewModel
import com.example.hilt.core.utils.toast
import com.example.hilt.presentation.ui.profile.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var TAG = LoginActivity::class.simpleName
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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.buttonLogin.setOnClickListener {
            login()
        }

        binding.textViewRegisterNow.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
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