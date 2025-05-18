package com.example.moja_aplikacja.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moja_aplikacja.db.Converters
import com.example.moja_aplikacja.model.Todo
import com.example.moja_aplikacja.db.TodoDao


@Database(entities = [Todo::class], version = 1)
@TypeConverters(Converters::class)
abstract class TodoDatabase : RoomDatabase() {

    companion object {
        const val NAME = "Todo_DB"
    }

    abstract fun getTodoDao(): TodoDao
}