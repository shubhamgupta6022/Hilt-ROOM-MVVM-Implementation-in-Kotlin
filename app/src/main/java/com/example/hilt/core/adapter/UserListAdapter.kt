package com.example.hilt.core.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hilt.R
import com.example.hilt.domain.model.Data

class UserListAdapter(private val context: Context, private var userListList: ArrayList<Data>) :
    RecyclerView.Adapter<UserListAdapter.UserListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListAdapter.UserListHolder {
        return UserListHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserListAdapter.UserListHolder, position: Int) {
        val userList = userListList[position]
        holder.email.text = userList.email.toString()
        holder.name.text = userList.first_name

        Glide.with(context)
            .load(userList.avatar)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return userListList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(userListList: ArrayList<Data>) {
        this.userListList = userListList
        notifyDataSetChanged()
    }

    inner class UserListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val email: TextView = itemView.findViewById(R.id.email)
        val image: ImageView = itemView.findViewById(R.id.image)
    }

}
