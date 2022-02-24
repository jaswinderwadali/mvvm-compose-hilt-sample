package r.bot.viewmodel

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import r.bot.common.NetworkResult
import r.bot.data.model.PhotosModel
import r.bot.data.repository.MainRepository
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

    init {
        getPhotos()
    }

    val snapshotStateList = SnapshotStateList<PhotosModel>()

    private fun getPhotos() = viewModelScope.launch {
        when (val result = mainRepository.getPhotos()) {
            is NetworkResult.Success -> {
                result.data?.let { snapshotStateList.addAll(it) }
            }
            else -> {

            }
        }


    }


}