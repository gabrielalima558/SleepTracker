package com.example.android.trackmysleepquality.sleepquality

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.trackmysleepquality.database.SleepDatabaseDao
import kotlinx.coroutines.*

class SleepQualityViewModel(
        private val sleepNightKey: Long = 0L,
        val databaseDao: SleepDatabaseDao) : ViewModel() {

    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        uiScope.cancel()
    }

    private val _navigateToSleepQuality = MutableLiveData<Boolean?>()

    val navigateToSleepQuality: LiveData<Boolean?>
        get() = _navigateToSleepQuality

    fun doneNavigation() {
        _navigateToSleepQuality.value = null
    }

    fun onSetSleepQuality(quality: Int) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                val tonight = databaseDao.get(sleepNightKey) ?: return@withContext
                tonight.sleepQuality = quality
                databaseDao.update(tonight)
            }
            _navigateToSleepQuality.value = true
        }
    }

}
