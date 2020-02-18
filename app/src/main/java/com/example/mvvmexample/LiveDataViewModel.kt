package com.example.mvvmexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import java.util.*

class LiveDataViewModel(val dataSource: DataSource) : ViewModel(){


    val currentTime = dataSource.getCurrentTime()

    val currentTimeTransformed = currentTime.switchMap {
        liveData { emit(timeStampToTime(it)) }
    }

    val number = dataSource.getCounter()

    fun incrementCounter() = dataSource.incrementNumber()

    private suspend fun timeStampToTime(it: Long): String {
        delay(500)
        return Date(it).toString()
    }
}

object LiveDataViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LiveDataViewModel(DefaultDataSource(Dispatchers.IO)) as T
    }

}