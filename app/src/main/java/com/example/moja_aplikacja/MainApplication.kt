package com.example.moja_aplikacja

import android.app.Application
import androidx.room.Room
import com.example.moja_aplikacja.db.TodoDatabase
import com.google.firebase.FirebaseApp


class MainApplication : Application() {

    companion object{
        lateinit var todoDatabase: TodoDatabase
    }

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        todoDatabase = Room.databaseBuilder(
            applicationContext,
            TodoDatabase::class.java,
            TodoDatabase.NAME
        ).build()
    }
}