package com.devmobile.tasklist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}

fun getDatabase(context: Context): AppDatabase {
    val db = Room.databaseBuilder(context, AppDatabase::class.java, "appdatabase.db").allowMainThreadQueries().build()
    return db
}