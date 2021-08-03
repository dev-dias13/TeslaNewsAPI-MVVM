package org.devdias.teslanewsapi_mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.devdias.teslanewsapi_mvvm.adapter.NewsAdapter
import org.devdias.teslanewsapi_mvvm.R
import org.devdias.teslanewsapi_mvvm.model.NewsArticles
import org.devdias.teslanewsapi_mvvm.viewModel.MainViewModel

/**
 * Created by Dias Bakhtybek on 03.08.2021.
 * MainActivity class
 **/
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar.visibility = View.VISIBLE
        initViewModel()
    }

    //Initialize view model
    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this,  {
            if(it != null) {
                setupRecyclerView(it)
                progressBar.visibility = View.GONE
                println("Success")
            } else {
                progressBar.visibility = View.GONE
                Toast.makeText(this, "Error: $it", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeAPICall()
    }

    //Setting up recycler view
    private fun setupRecyclerView(it: List<NewsArticles>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NewsAdapter(it)
        recyclerView.adapter = adapter
    }

}