package com.example.contactappfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contactappfirebase.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    var auth = FirebaseAuth.getInstance()
    lateinit var signUpBinding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = signUpBinding.root
        setContentView(view)

        signUpBinding.SignUpButton.setOnClickListener {
            val email = signUpBinding.EmailSignUpEdit.text.toString()
            val Password = signUpBinding.PasswordSignUpEdit.text.toString()

            SignUpFirebase(email,Password)
        }
    }

    fun SignUpFirebase(email : String,Password : String){
        auth.createUserWithEmailAndPassword(email,Password).addOnCompleteListener { Task ->
            if (Task.isSuccessful) {
                Toast.makeText(applicationContext, "Signed Up", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(applicationContext, Task.exception.toString(), Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }
}