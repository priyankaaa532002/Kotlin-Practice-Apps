package com.example.studentsdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_add_student.*
import kotlinx.android.synthetic.main.activity_main.*

class AddStudent : AppCompatActivity() {


    lateinit var viewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(StudentViewModel::class.java)
        viewModel.allStudent.observe(this, Observer {list -> //agar null nahi toh

        })
    }

    fun submitData(view: View) {
        val nameText = add_name_et.text.toString()
        val phoneText = add_phone_et.text.toString()
        val classText = add_class_et.text.toString()


        if (nameText.isNotEmpty()){
            viewModel.insertStudent(Student(nameText,phoneText,classText))
            Toast.makeText(this,"${nameText} Inserted", Toast.LENGTH_LONG).show()
        }
        finish() //purane activity mai wapis jaega
    }
}