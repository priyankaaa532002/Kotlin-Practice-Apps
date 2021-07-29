package com.example.studentsdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_student.*

class MainActivity : AppCompatActivity(), IStudentsRVAdapter {
    lateinit var viewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = StudentsRVAdapter(this,this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(StudentViewModel::class.java)
        viewModel.allStudent.observe(this, Observer {list -> //agar null nahi toh
            list?.let{
                adapter.updateList(it)
            }
        })


    }

    override fun onItemClicked(student: Student) {
        viewModel.deleteStudent(student)
        Toast.makeText(this,"${name.text} Deleted", Toast.LENGTH_LONG).show()
    }

    fun fabButton(view: View){
        val intent = Intent(this,AddStudent::class.java)
        startActivity(intent)
    }
}