package com.example.moja_aplikacja.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moja_aplikacja.MainApplication
import com.example.moja_aplikacja.model.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoViewModel : ViewModel() {

    private val todoDao = MainApplication.todoDatabase.getTodoDao()

    val todoList: LiveData<List<Todo>> = todoDao.getAllTodo()

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title: String) {
        if (title.isBlank()) return
        viewModelScope.launch(Dispatchers.IO) {
            val todo = Todo(title = title, createdAt = Date.from(Instant.now()))
            todoDao.addTodo(todo)
        }
    }

    fun deleteTodo(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.deleteTodo(id)
        }
    }

    fun updateTodo(id: Int, newText: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val existing = todoDao.getTodoById(id) ?: return@launch
            val updated = existing.copy(title = newText)
            todoDao.updateTodo(updated)
        }
    }

}
