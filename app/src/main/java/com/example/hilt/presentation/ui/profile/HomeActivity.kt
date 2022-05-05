package com.example.hilt.presentation.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hilt.R
import com.example.hilt.presentation.ui.profile.adapter.ProfileAdapter
import com.example.hilt.databinding.ActivityHomeBinding
import com.example.hilt.core.model.Data
import com.example.hilt.presentation.ui.profile.viewmodelfactory.ProfileViewModelFactory
import com.example.hilt.presentation.viewmodel.profile.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private var TAG = HomeActivity::class.simpleName
    private lateinit var recyclerView: RecyclerView
    private lateinit var profileAdapter: ProfileAdapter

    private lateinit var profileViewModel: ProfileViewModel
    private val userArrayList = ArrayList<Data>()

    @Inject
    lateinit var profileViewModelFactory: ProfileViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        profileViewModel =
            ViewModelProvider(this, profileViewModelFactory)[ProfileViewModel::class.java]

        profileAdapter = ProfileAdapter(this, ArrayList<Data>())
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = profileAdapter
        }

        profileViewModel.obsList.observe(this, Observer<List<Data>> {
            it.forEach { data ->
                userArrayList.add(data)
            }
            profileAdapter.setData(userArrayList)
        })

    }
}