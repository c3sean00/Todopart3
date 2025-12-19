package com.example.todo.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo.model.Todo
import com.example.todo.viewmodel.TodoUiState
import com.example.todo.viewmodel.TodoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoApp(modifier: Modifier = Modifier, todoViewModel: TodoViewModel = viewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Todos") }
            )
        }
    ) { innerPadding ->
        TodoScreen(
            modifier = modifier.padding(innerPadding),
            uiState = todoViewModel.todoUiState
        )
    }
}

@Composable
fun TodoScreen(modifier: Modifier = Modifier, uiState: TodoUiState) {
    when (uiState) {
        is TodoUiState.Loading -> LoadingScreen()
        is TodoUiState.Success -> TodoList(modifier, todos = uiState.todos)
        is TodoUiState.Error -> ErrorScreen()
    }
}

@Composable
fun LoadingScreen() {
    Text("Loading...")
}

@Composable
fun ErrorScreen() {
    Text("Error retrieving data from API.")
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
