package com.example.blogapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class CreatePost : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)
        val title: EditText=findViewById(R.id.editTitle)
        val desc: EditText=findViewById(R.id.TextDescription)
        val postbtn: Button=findViewById(R.id.post_btn)
        val mauth=FirebaseAuth.getInstance()
        val db=FirebaseFirestore.getInstance()
        postbtn.setOnClickListener {
            val mp= HashMap<String,String>()
            mp["title"]=title.text.toString()
            mp["description"]=desc.text.toString()
            mp["author"]=mauth.currentUser!!.displayName.toString()
            db.collection("blog").add(mp).addOnSuccessListener {
                Toast.makeText(this,"Data Added",Toast.LENGTH_SHORT).show()
                val intent=Intent(this,PostsActivity::class.java)
                startActivity(intent)
            }.addOnFailureListener {
                Toast.makeText(this,"Error Occured",Toast.LENGTH_SHORT).show()
            }
        }
    }
}