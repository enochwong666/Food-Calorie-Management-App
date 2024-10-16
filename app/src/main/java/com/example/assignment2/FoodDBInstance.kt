package com.example.assignment2

import android.content.Context
import androidx.room.Room

object FoodDBInstance {
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "food_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}