package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.adapter.PostAdapter
import com.example.retrofit.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //1.
    private lateinit var  viewModel: MainViewModel
    //AFTER CREATING RECYCLER VIEW -----> 1.
    private val myAdapter by lazy { PostAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //2.
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()

        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful){
                Log.d("Response", response.body()?.userId.toString())
                Log.d("Response", response.body()?.id.toString())
//                textView.text = response.body()?.title!!
                Log.d("Response", response.body()?.body!!)
            }else{
                Log.d("Response", response.errorBody().toString())
//                textView.text = response.code().toString()
            }
        })

        //AFTER CREATING RECYCLER VIEW -----> 3.
        setupRecyclerview()

        viewModel.getCustomPosts()
        viewModel.myResponse2.observe(this, Observer { response->
            if (response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
            }else{
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
    }

    //AFTER CREATING RECYCLER VIEW -----> 2.
    private fun setupRecyclerview(){
        rvPosts.adapter = myAdapter
        rvPosts.layoutManager = LinearLayoutManager(this)
    }
}