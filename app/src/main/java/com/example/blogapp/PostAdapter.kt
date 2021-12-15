package com.example.blogapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private val posts : ArrayList<Post>, private val context : Context) : RecyclerView.Adapter<PostAdapter.PostViewHolder>()  {
    inner class PostViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val title = view.findViewById<TextView>(R.id.titleTxt)
        val description = view.findViewById<TextView>(R.id.desTxt)
        val author=view.findViewById<TextView>(R.id.author)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item , parent , false)   //inflation layout as a view
        val holder = PostViewHolder(view)                                         //passing the above view into view holder

        return holder                                                             //returning holder
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val curr_post = posts[position]
        holder.title.text = curr_post.title
        holder.description.text = curr_post.title
        holder.author.text=curr_post.author
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}