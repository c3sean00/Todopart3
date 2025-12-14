package com.example.todo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold // Scaffold on lisätty
import androidx.compose.ui.Modifier
import com.example.todo.ui.screen.TodoScreen
import com.example.todo.ui.theme.TodoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoTheme {
                // Scaffold tarjoaa standardin Material Design -rakenteen.
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Kutsutaan päänäkymää ja annetaan sille padding,
                    // jotta sisältö ei mene järjestelmän palkkien alle.
                    TodoScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
