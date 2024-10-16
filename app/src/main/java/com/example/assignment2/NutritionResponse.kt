package com.example.assignment2

data class NutritionResponse(
    val items: List<Item>
)

data class Item(
    val name: String,
    val calories: Float,
    val fat_total_g: Float,
    val protein_g: Float,
    val carbohydrates_total_g: Float
)
