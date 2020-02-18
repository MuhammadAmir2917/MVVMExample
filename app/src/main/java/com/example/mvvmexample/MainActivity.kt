package com.example.mvvmexample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvmexample.databinding.ContentMainBinding

class MainActivity : AppCompatActivity() {

    private val viewmodel : LiveDataViewModel by viewModels { LiveDataViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ContentMainBinding>(this ,R.layout.content_main)

        binding.lifecycleOwner = this
        binding.viewmodel = viewmodel

    }


}
