package com.example.todo.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todo.viewmodel.TodoViewModel
import com.example.todo.model.Todo
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun TodoScreen(modifier: Modifier = Modifier, todoViewModel: TodoViewModel = viewModel()) {
    TodoList(modifier = modifier, todos = todoViewModel.todos)
}

@Composable
fun TodoList(
    modifier: Modifier = Modifier,
    todos: List<Todo>
) {
    LazyColumn(
        modifier = modifier.padding(16.dp)
    ) {
        items(todos) { todo ->
            Column(modifier = Modifier.padding(vertical = 8.dp)) {
                Text(
                    text = todo.title,
                    style = MaterialTheme.typography.bodyLarge
                )
                HorizontalDivider(modifier = Modifier.padding(top = 8.dp))
            }
        }
    }
}