package r.bot.data.repository

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import r.bot.common.BaseApiResponse
import r.bot.common.NetworkResult
import r.bot.data.api.ApiService
import r.bot.data.model.PhotosModel
import javax.inject.Inject

@ActivityRetainedScoped
class MainRepository @Inject constructor(private val apiService: ApiService) : BaseApiResponse() {
    suspend fun getPhotos(): kotlinx.coroutines.flow.Flow<NetworkResult<List<PhotosModel>>> {
        return flow {
            emit(safeApiCall { apiService.getPhotos() })
        }.flowOn(Dispatchers.IO)
    }

}