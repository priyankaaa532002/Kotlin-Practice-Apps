package com.example.studentsdata

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "students_table")
class Student (@ColumnInfo(name = "student_name")val name: String,
               @ColumnInfo(name = "phone_no")val phone: String,
               @ColumnInfo(name = "class")val class_: String
)
{
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}