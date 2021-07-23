package com.example.birthdaywishingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun createBirthdayCard(view: View){
        //using edit text
        val name = nameInput.editableText.toString()
        //Toast.makeText(this,"name is $name",Toast.LENGTH_LONG).show()

                                        //from --> to
        val intent = Intent(this,BirthdayGreeting::class.java)
        intent.putExtra("name_extra",name)
        startActivity(intent)
    }

}