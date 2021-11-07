package com.example.retrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.repository.Repository

//STEP 7
class MainViewModelFactory(
    private val repository: Repository
    ): ViewModelProvider.Factory { //ctrl+I
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}