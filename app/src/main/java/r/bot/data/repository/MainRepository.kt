package r.bot.data.repository

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import r.bot.common.BaseApiResponse
import r.bot.common.NetworkResult
import r.bot.data.api.ApiService
import r.bot.data.model.PhotosModel
import javax.inject.Inject

@ActivityRetainedScoped
class MainRepository @Inject constructor(private val apiService: ApiService,private val defaultDispatcher: CoroutineDispatcher) : BaseApiResponse() {
    suspend fun getPhotos() : NetworkResult<List<PhotosModel>>{
           return withContext(defaultDispatcher){safeApiCall { apiService.getPhotos() }}
    }

}