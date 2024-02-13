package com.example.contactappfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contactappfirebase.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    var auth = FirebaseAuth.getInstance()
    lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        val view = loginBinding.root
        super.onCreate(savedInstanceState)
        setContentView(view)

        loginBinding.SignInButton.setOnClickListener {
            val email = loginBinding.EmailEditid.text.toString()
            val password = loginBinding.PasswordEditid.text.toString()

            SigninFirebase(email,password)
        }

        loginBinding.SignUp.setOnClickListener {
            val intent = Intent(this@LoginActivity,SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun SigninFirebase(email : String,Password : String){
        auth.signInWithEmailAndPassword(email,Password).addOnCompleteListener { Task ->
            if (Task.isSuccessful) {
                Toast.makeText(applicationContext, "Signed In", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(applicationContext, Task.exception.toString(), Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }
}