package com.example.todo.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.model.Todo
import com.example.todo.model.TodosApiService // Corrected import
import kotlinx.coroutines.launch

sealed interface TodoUiState {
    data class Success(val todos: List<Todo>) : TodoUiState
    object Error : TodoUiState
    object Loading : TodoUiState
}

class TodoViewModel : ViewModel() {
    var todoUiState: TodoUiState by mutableStateOf<TodoUiState>(TodoUiState.Loading)
        private set

    init {
        getTodosList()
    }

    fun getTodosList() {
        todoUiState = TodoUiState.Loading
        viewModelScope.launch {
            try {
                // Use the correct service class TodosApiService
                val apiService = TodosApiService.getInstance()
                todoUiState = TodoUiState.Success(apiService.getTodos())
            } catch (e: Exception) {
                Log.d("TODOVIEWMODEL", "Failed to get todos: ${e.message}")
                todoUiState = TodoUiState.Error
            }
        }
    }
}
