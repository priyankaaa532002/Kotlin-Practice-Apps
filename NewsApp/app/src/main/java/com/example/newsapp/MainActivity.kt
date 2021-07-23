package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsItemClicked {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Step 1: Add layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)


        val items = fetchData()
        //Step 9 binding adapter to recycler view
        val adapter = NewsListAdapter(items, this)
                                        //Step 14: listener added(this)
        //let main activity implement interface
        recyclerView.adapter = adapter
    }

    //Dummy Data
    private fun fetchData():ArrayList<String>{
        val list = ArrayList<String>()
        for(i in 0 until 100){
            list.add("Item $i")
        }
        return list
    }

    override fun onItemClicked(item: String) {
        //item clicks here after step 14
        Toast.makeText(this,"Clicked item is $item" , Toast.LENGTH_LONG).show()
    }
}