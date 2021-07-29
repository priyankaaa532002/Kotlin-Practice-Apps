package com.example.studentsdata

import android.provider.ContactsContract
import androidx.lifecycle.LiveData

class StudentsRepository(private val studentDao: StudentDao) {
    val allStudents : LiveData<List<Student>> = studentDao.getAllStudents()

    suspend fun insert(student: Student){
        studentDao.insert(student)
    }

    suspend fun delete(student: Student){
        studentDao.delete(student)
    }
}