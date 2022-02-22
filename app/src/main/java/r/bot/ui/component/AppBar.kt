package r.bot.ui.component

import android.widget.Toast
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ToolbarWidget(name: String,content: @Composable () -> Unit) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = name,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Work in progress", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(Icons.Filled.Menu, "MenuIcon")
                    }
                },
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                elevation = 12.dp
            )
        }, content = { content() },
        bottomBar = {

        })
}

