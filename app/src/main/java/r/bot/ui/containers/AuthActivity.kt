package r.bot.ui.containers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import r.bot.ui.containers.ui.theme.RbotTheme

class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RbotTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainContent("Android")
                }
            }
        }
    }
}

@Composable
fun MainContent(name: String) {
    var text by remember { mutableStateOf("") }
    Column() {
        Text(text = "Welcome To Rbot")
        TextField(value = text, onValueChange = { text = it })
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    RbotTheme {
        MainContent("Android")
    }
}