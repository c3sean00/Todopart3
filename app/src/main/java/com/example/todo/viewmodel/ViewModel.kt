package com.example.todo.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.model.Todo
import com.example.todo.model.TodosApiService
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {
    var todos: List<Todo> by mutableStateOf(listOf())

    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            try {
                val apiService = TodosApiService.getInstance()
                todos = apiService.getTodos()
            } catch (e: Exception) {
                Log.d("TODOVIEWMODEL", e.message.toString())
            }
        }
    }
}