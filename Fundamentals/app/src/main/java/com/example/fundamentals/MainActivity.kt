package com.example.fundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count = 0
        btnApply.setOnClickListener{

            count++
            tvCount.text = "The count is : $count"

            val firstName = etFirstName.text.toString()
            val lastName = etLastName.text.toString()
            val birthDate = etBirthDate.text.toString()
            val country = etCountry.text.toString()
            //to change to into
            val phone = etPhone.text.toString().toInt()
            //FOR SETTING IMAGE ---->
            //ivimage.setImageResource(R.drawable.IMAGE_ID)

            Log.d("MainActivity","$firstName $lastName of birthdate $birthDate from $country has applied for the form")

        }
    }
}