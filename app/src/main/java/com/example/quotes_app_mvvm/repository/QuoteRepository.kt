package com.example.quotes_app_mvvm.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quotes_app_mvvm.api.QuoteService
import com.example.quotes_app_mvvm.db.QuoteDatabase
import com.example.quotes_app_mvvm.models.QuoteList
import com.example.quotes_app_mvvm.util.NetworkUtil

class QuoteRepository(
    private val quoteService: QuoteService,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context,) {
    private val quotesLiveData=MutableLiveData<QuoteList>()

    val quotes:LiveData<QuoteList>
    get()=quotesLiveData
    suspend fun getQuotes(page:Int)
    {


        if(NetworkUtil.isInternetAvailable(applicationContext)){
            val result = quoteService.getQuotes(page)
            if(result?.body() != null){
                quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
                quotesLiveData.postValue(result.body())
            }
        }
        else{
            val quotes = quoteDatabase.quoteDao().getQuotes()
            val quoteList = QuoteList(1,1,1,quotes, 1, 1)
            quotesLiveData.postValue(quoteList)
        }
    }
}