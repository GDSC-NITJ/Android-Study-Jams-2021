package com.example.newapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class PostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        val addPost: FloatingActionButton=findViewById(R.id.addPost)
        addPost.setOnClickListener {
            val intent= Intent(this,CreatePost::class.java)
            startActivity(intent)
        }

        val recyclerView:RecyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)

        val postlist: ArrayList<Post> = arrayListOf()
        val adapter:PostAdapter=PostAdapter(postlist)
        recyclerView.adapter=adapter

        val db=FirebaseFirestore.getInstance()
        db.collection("blog").get().addOnSuccessListener {
            val list: MutableList<DocumentSnapshot> = it.documents
            for(document in list)
            {
                val postdata:Post= Post(
                    document.get("title").toString(),
                    document.get("description").toString(),
                    document.get("author").toString()
                )
                postlist.add(postdata)
                adapter.notifyDataSetChanged()
            }
        }.addOnFailureListener {
            Toast.makeText(this,"Error While Fetching Data",Toast.LENGTH_SHORT).show()
        }
    }
}