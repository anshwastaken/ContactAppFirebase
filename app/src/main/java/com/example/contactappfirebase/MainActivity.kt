package com.example.contactappfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactappfirebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        super.onCreate(savedInstanceState)
        setContentView(view)
        mainBinding.AddFloatButton.setOnClickListener {
            val intent = Intent(this@MainActivity,AddInformationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}