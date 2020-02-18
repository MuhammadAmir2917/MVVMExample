package com.example.mvvmexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay

class DefaultDataSource (val dispatcher: CoroutineDispatcher) : DataSource {
    private var counter : Long = 0
    override fun getCurrentTime(): LiveData<Long> =
        liveData {
            while (true){
                emit(System.currentTimeMillis())
                delay(1000)
            }
        }

    override fun getCounter(): LiveData<Long> =
        liveData { while (true){
            delay(500)
            emit(counter)
        }  }

   override fun incrementNumber(){
        counter++
    }

}

interface DataSource{
    fun getCurrentTime() : LiveData<Long>
    fun getCounter() : LiveData<Long>
    fun incrementNumber()

}