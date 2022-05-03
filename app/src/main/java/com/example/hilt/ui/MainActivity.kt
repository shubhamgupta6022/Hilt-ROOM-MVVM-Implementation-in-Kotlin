package com.example.hilt.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.hilt.R
import com.example.hilt.databinding.ActivityMainBinding
import com.example.hilt.domain.model.User
import com.example.hilt.presentation.UserViewModel
import com.example.hilt.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var TAG = MainActivity::class.simpleName
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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

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
                toast(this@MainActivity, "Error")
            } else {
                Log.d("MainActivity", "uid: $uid")
                toast(this@MainActivity, "uid: $uid")

                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)

            }
        }

    }
}