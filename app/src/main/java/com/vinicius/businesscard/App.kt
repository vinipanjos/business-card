package com.vinicius.businesscard

import android.app.Application
import com.vinicius.businesscard.data.AppDatabase
import com.vinicius.businesscard.data.BusinessCardRepository

class App: Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy{ BusinessCardRepository(database.businessDao())}
}