package com.example.recyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

class TodoAdapter (
    //STEP 3
    var todos: List<Todo>
        ): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){

    //STEP 1 (AFTER MAKING XML FOR RV AND ITEM
    //1.1 CREATE VIEW HOLDER INNER CLASS FOR HOLDING ITEM
    inner class TodoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    //STEP 4
    //CTRL + I
    //IMPLEMENT METHODS AS RV IS AN ABSTRACT CLASS
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.apply {
            tvTitle.text = todos[position].title
            cbDone.isChecked = todos[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}