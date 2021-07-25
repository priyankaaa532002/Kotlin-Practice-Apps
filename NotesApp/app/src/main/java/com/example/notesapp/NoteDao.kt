package com.example.notesapp

import androidx.lifecycle.LiveData
import androidx.room.*

//Step 2 --> making dao

@Dao
interface NoteDao {

    //insert and delete will work in background thread
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>
}