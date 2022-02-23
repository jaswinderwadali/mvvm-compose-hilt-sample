package r.bot.data.model

import com.google.gson.annotations.SerializedName


data class PhotosModel(
    @field:SerializedName("title")
    val title: String,
    @field:SerializedName("id")
    val id: String,
    @field:SerializedName("url")
    val url: String
)
