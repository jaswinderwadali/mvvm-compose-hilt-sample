package r.bot.ui.containers

import Ui
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import r.bot.R
import r.bot.app.TEXT
import r.bot.app.USER
import r.bot.data.ChatModel
import r.bot.data.chat_list
import r.bot.ui.component.ToolbarWidget
import r.bot.ui.theme.RbotTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RbotTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ToolbarWidget(getString(R.string.app_name)) {
                        Column(Modifier.fillMaxSize()) {
                            MainContainer()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainContainer() {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier.fillMaxHeight(1f), contentAlignment = Alignment.TopCenter
    ) {
        Column {
            LazyColumn(
                Modifier.weight(1f),
                state = listState,
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(
                    items = chat_list,
                    itemContent = {
                        if (it.type == TEXT)
                            Ui.ChatBubble(chatModel = it)
                    })
            }
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
            )
            Row {
                TextField(
                    modifier = Modifier.weight(1f),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        cursorColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    value = text,
                    onValueChange = {
                        text = it
                    }
                )
                IconButton(onClick = {
                    if (text.isEmpty()) {
                        Toast.makeText(context, "Please enter something", Toast.LENGTH_SHORT).show()
                        return@IconButton
                    }
                    sendMessage(text = text, state = listState, scope = coroutineScope)
                    text = ""
                }) {
                    Icon(Icons.Filled.Send, "Send Button")
                }
            }

        }
    }
}


fun sendMessage(text: String, state: LazyListState, scope: CoroutineScope) {
    chat_list.add(ChatModel(text, TEXT, USER))
    scope.launch {
        state.animateScrollToItem(index = chat_list.size - 1)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val context = LocalContext.current;
    RbotTheme {
        ToolbarWidget(context.getString(R.string.app_name)) {
            Column(Modifier.fillMaxSize()) {
                MainContainer()
            }
        }
    }
}