package com.example.retrofit.api

import com.example.retrofit.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//STEP 2
//MAKE INTERFACE (API RELATED)

interface SimpleApi {
    @GET("posts/1")
    suspend fun getPost() : Response<Post>

    @GET("posts")
    suspend fun getCustomPosts() : Response<List<Post>>
}