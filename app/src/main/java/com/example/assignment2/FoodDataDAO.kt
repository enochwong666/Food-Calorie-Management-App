package com.example.assignment2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
public interface FoodDataDAO {
    @Insert
    suspend fun insert(food: Food)

    @Query("SELECT * FROM food")
    suspend fun getAllFoodItems(): List<Food>
}