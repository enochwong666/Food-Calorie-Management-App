package com.example.assignment2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
public class Food (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val portionSize: Long,
    val mealType: String,
    val numOfCal: Int
)