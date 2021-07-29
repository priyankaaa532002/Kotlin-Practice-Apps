package com.example.studentsdata

import android.app.Application
import android.content.Context
import android.provider.ContactsContract
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


//Step DataBase
@Database(entities = arrayOf(Student::class),version = 1,exportSchema = false)
abstract class StudentDataBase : RoomDatabase() {

    abstract fun getStudentDao(): StudentDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: StudentDataBase? = null

        fun getDatabase(context: Context): StudentDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentDataBase::class.java,
                    "student_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}