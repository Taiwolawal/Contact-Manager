package com.example.android.contactmanager

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.android.contactmanager.db.ContactDatabase

class ContactApplication : Application() {
    companion object {
        lateinit var database: ContactDatabase
            private set
    }
    override fun onCreate() {
        super.onCreate()
        database = Room
            .databaseBuilder(
                this,
                ContactDatabase::class.java,
                "contact_database"
            )
            .build()
    }
}