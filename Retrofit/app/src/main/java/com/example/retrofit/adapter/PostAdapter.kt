package com.example.retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.model.Post
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter :RecyclerView.Adapter<PostAdapter.PostViewHolder>(){

    private var posts = emptyList<Post>()
    inner class PostViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.itemView.apply {
            tv_id.text = posts[position].id.toString()
            tv_userId.text = posts[position].userId.toString()
            tv_title.text = posts[position].title
            tv_body.text = posts[position].body
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun setData(newList: List<Post>){
        posts = newList
        notifyDataSetChanged()
    }
}