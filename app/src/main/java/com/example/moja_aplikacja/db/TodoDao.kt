package com.example.moja_aplikacja.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.moja_aplikacja.model.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM Todo ORDER BY createdAt DESC")
    fun getAllTodo(): LiveData<List<Todo>>

    @Insert
    fun addTodo(todo: Todo)

    @Query("DELETE FROM Todo where id = :id")
    fun deleteTodo(id: Int)

    @Update
    fun updateTodo(todo: Todo)

    @Query("SELECT * FROM Todo WHERE id = :id")
    fun getTodoById(id: Int): Todo?


}
