package com.example.blogapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class PostsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter
        val db= FirebaseFirestore.getInstance()
        val userList: ArrayList<Post> = arrayListOf()
        val adapter: PostAdapter=PostAdapter(userList,this)
        recyclerView.adapter=adapter
        db.collection("blog").get().addOnSuccessListener{
            val list: MutableList<DocumentSnapshot> = it.documents
            for(d in list)
            {
                val blog: Post=Post(d.get("title").toString(), d.get("description").toString(),d.get("author").toString())
                userList.add(blog)
            }
            adapter.notifyDataSetChanged()
        }
        val addPost:FloatingActionButton=findViewById(R.id.addPost)
        addPost.setOnClickListener {
            val intent= Intent(this,CreatePost::class.java)
            startActivity(intent)
        }
    }
}