package com.example.newapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        val recyclerView:RecyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)

        val titleList=ArrayList<String>()
        val descList=ArrayList<String>()
        val authList=ArrayList<String>()

        for(i in 0 until 100){
            titleList.add("Title $i")
            descList.add("Desc $i")
            authList.add("Author $i")
        }

        val adapter:PostAdapter=PostAdapter(titleList,descList,authList)
        recyclerView.adapter=adapter

    }
}