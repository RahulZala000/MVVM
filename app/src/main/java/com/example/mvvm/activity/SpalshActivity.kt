package com.example.mvvm.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.mvvm.R


class SpalshActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh)

        supportActionBar!!.hide()

        Handler().postDelayed({
            var i= Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()
        },3000)
    }
}