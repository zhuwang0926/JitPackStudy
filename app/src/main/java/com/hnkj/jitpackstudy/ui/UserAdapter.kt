package com.hnkj.jitpackstudy.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hnkj.jitpackstudy.R
import com.hnkj.jitpackstudy.data.User
import com.hnkj.jitpackstudy.viewModels.UserViewModel

/**
 * @author: zhuw
 * Created by zhuwang 2021-08-02-星期一-上午11:52
 * Email zhuwang999@foxmail.com
 */
class UserAdapter(private val userViewModel: UserViewModel) :
    ListAdapter<User, UserAdapter.UserViewHolder>(UsersComparator()) {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName = itemView.findViewById<TextView>(R.id.tv_name)
        private val tvDescription = itemView.findViewById<TextView>(R.id.tv_description)

        fun bind(user: User) {
            tvName.text = user.name
            tvDescription.text = user.description
        }

        companion object {
            fun create(parent: ViewGroup): UserViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_user, parent, false)
                return UserViewHolder(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.create(parent).apply {
            itemView.rootView.setOnClickListener {
                Toast.makeText(
                    parent.context,
                    parent.context.getString(R.string.delete_user, getItem(adapterPosition).name),
                    Toast.LENGTH_SHORT
                ).show()
                userViewModel.deleteUser(getItem(adapterPosition))
            }
        }
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class UsersComparator : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return when {
            oldItem.userId == newItem.userId -> true
            oldItem.name == newItem.name -> true
            oldItem.description == newItem.description -> true
            else -> false
        }

    }
}