package com.example.studentsdata

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//add constructor and parameter..
class StudentViewModel(application: Application) : AndroidViewModel(application) {

    val repository: StudentsRepository
    val allStudent: LiveData<List<Student>>

    init {
        val dao = StudentDataBase.getDatabase(application).getStudentDao()
        repository = StudentsRepository(dao)
        allStudent = repository.allStudents
    }

    fun deleteStudent(student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(student)
    }

    fun insertStudent(student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(student)
    }
}