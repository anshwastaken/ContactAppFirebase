package com.example.contactappfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contactappfirebase.databinding.ActivityAddInformationBinding
import com.google.firebase.database.FirebaseDatabase

class AddInformationActivity : AppCompatActivity() {
    var database = FirebaseDatabase.getInstance()
    var myref = database.reference.child("Patient Data")
    lateinit var addInformationBinding: ActivityAddInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addInformationBinding = ActivityAddInformationBinding.inflate(layoutInflater)
        val view = addInformationBinding.root
        setContentView(view)

        addInformationBinding.DoneButton.setOnClickListener {
            AddPatientDataToDatabase()
        }

        addInformationBinding.imageView2.setOnClickListener{
            
        }

    }

    fun AddPatientDataToDatabase(){
        val id : String = myref.push().key.toString()
        val name : String = addInformationBinding.NameEdit.toString()
        val age : Int = addInformationBinding.AgeEdit.toString().toInt()
        val disease : String = addInformationBinding.DiseaseEdit.toString()
        val contact : Int = addInformationBinding.contactEdit.toString().toInt()

        val data = DataClass(id,name,age,disease,contact)

        myref.child(id).setValue(data).addOnCompleteListener {
            task ->
            if(task.isSuccessful){
                Toast.makeText(applicationContext,"User Saved",Toast.LENGTH_SHORT).show()
                val intent = Intent(this@AddInformationActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}