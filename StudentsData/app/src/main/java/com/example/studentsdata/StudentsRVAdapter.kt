package com.example.studentsdata

import android.content.Context
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class StudentsRVAdapter(private val context: Context, private val listener: IStudentsRVAdapter): RecyclerView.Adapter<StudentsRVAdapter.StudentViewHolder>() {

    val allStudents = ArrayList<Student>()
    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.name)
        val phone = itemView.findViewById<TextView>(R.id.phone)
        val class_ = itemView.findViewById<TextView>(R.id.class_)
        val image = itemView.findViewById<ImageView>(R.id.image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val viewHolder = StudentViewHolder(LayoutInflater.from(context).inflate(R.layout.item_student,parent,false))
        viewHolder.image.setOnClickListener {
            listener.onItemClicked(allStudents[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val currentStudent = allStudents[position]
        holder.name.text = currentStudent.name
        holder.phone.text = currentStudent.phone
        holder.class_.text = currentStudent.class_
        holder.image.setImageResource(R.drawable.ic_launcher_foreground)

    }

    override fun getItemCount(): Int {
        return allStudents.size
    }

    fun updateList(newList: List<Student>){
        allStudents.clear()
        allStudents.addAll(newList)

        notifyDataSetChanged()
    }
}

interface IStudentsRVAdapter {
    fun onItemClicked(student: Student)
}