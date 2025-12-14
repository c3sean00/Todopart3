package com.example.todo.viewmodel

import androidx.compose.runtime.mutableStateListOf // <-- LISÄÄ TÄMÄ IMPORT
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
    val todos = mutableStateListOf<String>()

    init {
        // Alustetaan data kuten ennenkin
        todos.add("Testaa ViewModel")
        todos.add("Yhdistä UI ja data")
        todos.add("Viimeistele arkkitehtuuri")
    }
}