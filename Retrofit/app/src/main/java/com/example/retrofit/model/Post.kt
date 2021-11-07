package com.example.retrofit.model

//STEP 1
//MAKE MODEL CLASS->DATA CLASS

data class Post (
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
    )