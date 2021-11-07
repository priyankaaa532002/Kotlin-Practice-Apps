package com.example.retrofit.repository

import com.example.retrofit.api.RetrofitInstance
import com.example.retrofit.model.Post
import retrofit2.Response

//STEP 5
//CREATE REPO
class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getCustomPosts(): Response<List<Post>>{
        return RetrofitInstance.api.getCustomPosts()
    }
}