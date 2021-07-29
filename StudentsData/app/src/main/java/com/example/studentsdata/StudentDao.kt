package com.example.studentsdata

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {
    //insert and delete will work in background thread
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Student)

    @Delete
    fun delete(note: Student)

    @Query("Select * from students_table order by id ASC")
    fun getAllStudents(): LiveData<List<Student>>
}