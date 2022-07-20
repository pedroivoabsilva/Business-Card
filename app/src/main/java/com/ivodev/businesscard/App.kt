package com.ivodev.businesscard

import android.app.Application
import com.ivodev.businesscard.data.AppDatabase
import com.ivodev.businesscard.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}