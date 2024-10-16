package com.example.assignment2

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Food::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun foodDataDao(): FoodDataDAO
}