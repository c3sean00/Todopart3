package com.example.todo.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel // <-- Tärkeä import-lause!
import com.example.todo.viewmodel.TodoViewModel

// Tämä on "älykäs" komponentti, joka tuntee ViewModelin.
@Composable
fun TodoScreen(modifier: Modifier = Modifier, todoViewModel: TodoViewModel = viewModel()) {
    TodoList(modifier, todos = todoViewModel.todos)
}

@Composable
fun TodoList(modifier: Modifier = Modifier, todos: List<String>) {
    LazyColumn(
        modifier = modifier.padding(8.dp)
    ) {
        items(todos) { todo ->
            Text(
                text = todo,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
        }
    }
}
