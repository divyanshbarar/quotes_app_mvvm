package com.example.quotes_app_mvvm

import android.app.Application
import com.example.quotes_app_mvvm.api.QuoteService
import com.example.quotes_app_mvvm.api.RetroFitHelper
import com.example.quotes_app_mvvm.db.QuoteDatabase
import com.example.quotes_app_mvvm.repository.QuoteRepository

class QuoteApplication:Application() {
    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetroFitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, database,applicationContext)
    }
}