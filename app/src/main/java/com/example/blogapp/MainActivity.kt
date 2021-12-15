package com.example.blogapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.common.api.ApiException

import com.google.android.gms.auth.api.signin.GoogleSignInAccount

import android.content.Intent

import android.app.Activity
import android.util.Log
import android.widget.Button
import android.widget.TextView

import androidx.activity.result.ActivityResultCallback

import androidx.activity.result.contract.ActivityResultContracts

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mauth=FirebaseAuth.getInstance()
        val button:Button=findViewById(R.id.button)
        button.setOnClickListener {
            mauth.signOut()
            val intent=Intent(this,Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}