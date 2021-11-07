package com.example.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.model.Post
import com.example.retrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

//STEP 6
//MAKE VIEW MODEL
class MainViewModel(private val repository: Repository) :ViewModel() {

    val myResponse : MutableLiveData<Response<Post> > = MutableLiveData()
    val myResponse2 : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    fun getPost(){
        viewModelScope.launch {
            val response : Response<Post> = repository.getPost()
            myResponse.value = response
        }
    }

    fun getCustomPosts(){
        viewModelScope.launch {
            val response: Response<List<Post>> = repository.getCustomPosts()
            myResponse2.value = response
        }
    }
}