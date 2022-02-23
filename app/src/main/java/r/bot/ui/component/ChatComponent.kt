import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import r.bot.app.USER
import r.bot.data.model.ChatModel


object Ui {
    @Composable
    fun ChatBubble(chatModel: ChatModel) {
        val left = chatModel.from == USER;
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = if (left) Alignment.CenterEnd else Alignment.CenterStart
        ) {
            Card(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                elevation = 2.dp,
                backgroundColor = Color.White,
                shape = RoundedCornerShape(corner = CornerSize(16.dp))
            ) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.End,
                    text = chatModel.value
                )
            }
        }
    }
}


