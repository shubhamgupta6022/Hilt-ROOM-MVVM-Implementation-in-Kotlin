package com.example.hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hilt.domain.network.Retrofit
import com.example.hilt.R
import com.example.hilt.core.adapter.UserListAdapter
import com.example.hilt.databinding.ActivityHomeBinding
import com.example.hilt.domain.model.Data
import com.example.hilt.domain.repository.ApiRepository
import com.example.hilt.domain.viewModelFactory.ApiViewModelFactory
import com.example.hilt.presentation.ApiViewModel
import com.example.hilt.presentation.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private var TAG = HomeActivity::class.simpleName
    private lateinit var recyclerView: RecyclerView
    private lateinit var userListAdapter: UserListAdapter

    private lateinit var apiViewModel: ApiViewModel
    private val userArrayList = ArrayList<Data>()

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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        val api = Retrofit.api
        val repository = ApiRepository(api = api)
        apiViewModel =
            ViewModelProvider(this, ApiViewModelFactory(repository))[ApiViewModel::class.java]

        userListAdapter = UserListAdapter(this, ArrayList<Data>())
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = userListAdapter
        }

        apiViewModel.obsList.observe(this, Observer<List<Data>> {
            it.forEach { data ->
                userArrayList.add(data)
            }
            userListAdapter.setData(userArrayList)
        })

    }
}