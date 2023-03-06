package com.example.quotes_app_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quotes_app_mvvm.api.QuoteService
import com.example.quotes_app_mvvm.api.RetroFitHelper
import com.example.quotes_app_mvvm.databinding.ActivityMainBinding
import com.example.quotes_app_mvvm.repository.QuoteRepository
import com.example.quotes_app_mvvm.viewmodels.MainViewModel
import com.example.quotes_app_mvvm.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    lateinit var adapter: QuoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


       val repository=(application as QuoteApplication).quoteRepository
        mainViewModel=ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {
            Log.d("divyansh",it.results.toString())
            adapter= QuoteAdapter(this@MainActivity,it.results)
            binding.quoteList.adapter=adapter
            binding.quoteList.layoutManager=LinearLayoutManager(this)
//            binding.quotes=it.results.toString()
//           val key =it.results
//            for( e in key)
//            {
//                binding.quotes=e.content
//            }
        })
    }
}