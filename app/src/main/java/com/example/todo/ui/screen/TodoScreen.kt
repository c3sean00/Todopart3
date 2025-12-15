package com.example.todo.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel // <-- Tärkeä import-lause!
import com.example.todo.viewmodel.TodoViewModel
import com.example.todo.model.Todo


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
        items(todos) { todo -> // 'todo' on nyt kokonainen Todo-olio
            Column(modifier = Modifier.padding(vertical = 8.dp)) {
                Text(
                    text = todo.title,
                    style = MaterialTheme.typography.bodyLarge
                )
                Divider(modifier = Modifier.padding(top = 8.dp))
            }
        }
    }
}
