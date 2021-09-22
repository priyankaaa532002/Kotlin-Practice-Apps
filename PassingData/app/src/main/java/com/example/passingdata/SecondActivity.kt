package com.example.passingdata

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        val name = intent.getStringExtra("EXTRA_NAME")
//        val age = intent.getIntExtra("EXTRA_AGE",0)
//        val country = intent.getStringExtra("EXTRA_COUNTRY")
        val person = intent.getSerializableExtra("EXTRA_PERSON") as Person
        //val personString = "$name is $age years old and lives in $country"
        //tvPerson.text = personString
        tvPerson.text = person.toString()

        btnTakePhoto.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it,0)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 0){
            val uri = data?.data
            ivPhoto.setImageURI(uri)
        }
    }
}