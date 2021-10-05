package com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.databinding.RvRowBinding
import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.model.GithubModelItem

class RvAdapter :
    RecyclerView.Adapter<RvAdapter.MyViewHolder>() {
    inner class MyViewHolder(val binding: RvRowBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<GithubModelItem>() {
        override fun areItemsTheSame(oldItem: GithubModelItem, newItem: GithubModelItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: GithubModelItem,
            newItem: GithubModelItem
        ): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, diffCallBack)
    var listGithub: List<GithubModelItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RvRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentGit = listGithub[position]

        holder.binding.apply {
            tvName.text = currentGit.name
            tvDesc.text = currentGit.description
            imageAvatarUrl.load(currentGit.owner?.avatar_url)
        }
    }

    override fun getItemCount() = listGithub.size


}

