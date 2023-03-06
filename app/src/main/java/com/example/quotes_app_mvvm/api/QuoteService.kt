package com.example.quotes_app_mvvm.api


import com.example.quotes_app_mvvm.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {  //second have to make a interface

    @GET("/quotes")
     suspend fun getQuotes(@Query("page") page: Int) : Response<QuoteList>

     //BASE_QUERY+"/quotes" + page_no.
}