package com.example.hilt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.hilt.databinding.ActivityMainBinding
import com.example.hilt.db.UserRepository
import com.example.hilt.db.UserViewModel
import com.example.hilt.db.UserViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel

    @Inject lateinit var viewModelFactory: UserViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        userViewModel = ViewModelProvider(this, viewModelFactory)[UserViewModel::class.java]

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
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
            } else {
                Log.d("MainActivity", "uid: $uid")
                Toast.makeText(applicationContext, "uid: $uid", Toast.LENGTH_LONG).show()
            }
        }

    }
}