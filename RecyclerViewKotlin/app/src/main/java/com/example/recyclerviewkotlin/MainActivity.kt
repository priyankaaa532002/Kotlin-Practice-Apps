package com.example.recyclerviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_todo.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //RECYCLER VIEW -->

        //STEP 5(CREATE THE TODOS LIST )
        var todoList = mutableListOf(
            Todo("Play Game BGMI",false),
            Todo("Play Game CR",false),
            Todo("Study DSA",false),
            Todo("Study App Dev",false),
            Todo("Exercise",false),
            Todo("Play Game BGMI",false),
            Todo("Play Game BGMI",false),
            Todo("Play Game BGMI",false),
        )

        //STEP 6(MAKE THE ADAPTER)
        val adapter = TodoAdapter(todoList)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        //STEP 7 -->
        btnAddTodo.setOnClickListener {
            val title = etTodo.text.toString()
            val todo = Todo(title,false)
            todoList.add(todo)
            //adapter.notifyDataSetChanged()
            //This will update the whole list
            adapter.notifyItemInserted(todoList.size-1)
            //This will update the position
        }
    }
}