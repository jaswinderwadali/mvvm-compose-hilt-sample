package r.bot.data.api

import r.bot.data.model.PhotosModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/photos")
    suspend fun getPhotos(): Response<List<PhotosModel>>

}
