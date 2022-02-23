package r.bot.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import r.bot.data.model.PhotosModel

@Composable
fun BasicCard(photosModel: PhotosModel) {
    Card(modifier = Modifier
        .padding(8.dp)
        .width(IntrinsicSize.Max)) {
        Row {
            Image(
                painter = rememberImagePainter(photosModel.url, builder = {
                    transformations(CircleCropTransformation())
                }),
                contentDescription = photosModel.title,
                modifier = Modifier
                    .size(70.dp)
                    .padding(8.dp)
            )
            Text(modifier = Modifier
                .padding(8.dp).weight(1f), text = photosModel.title)
        }

    }
}