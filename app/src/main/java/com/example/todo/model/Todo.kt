package com.example.todo.model

data class Success(val todos: List<Todo>)
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)