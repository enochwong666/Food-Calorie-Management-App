package com.example.assignment2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var apiService: CalorieNinjasApi
    private lateinit var nutritionInfoTextView: TextView
    private lateinit var foodInputEditText: EditText
    private lateinit var searchButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        nutritionInfoTextView = findViewById(R.id.tv_nutrition_info)
        foodInputEditText = findViewById(R.id.et_food_name)
        searchButton = findViewById(R.id.btn_search)

        // Initialize Retrofit service
        apiService = RetrofitClient.getClient("https://api.calorieninjas.com/")
            .create(CalorieNinjasApi::class.java)

        // Set search button click listener
        searchButton.setOnClickListener {
            val foodName = foodInputEditText.text.toString().trim()
            if (foodName.isNotEmpty()) {
                searchFood(foodName)
            } else {
                Toast.makeText(this, "Please enter a food name", Toast.LENGTH_SHORT).show()
            }
        }
    }

private fun searchFood(foodName: String) {
    val apiKey = "YdynOdYnR9yLt1QeZVnFc3z3kjx8dxokCL2az3gw"  // Replace with your actual API key

    val call = apiService.getNutritionInfo(foodName, apiKey)
    call.enqueue(object : Callback<NutritionResponse> {
        @SuppressLint("SetTextI18n")
        override fun onResponse(call: Call<NutritionResponse>, response: Response<NutritionResponse>) {
            if (response.isSuccessful && response.body() != null) {
                val items = response.body()?.items ?: emptyList()
                if (items.isNotEmpty()) {
                    val item = items[0]
                    nutritionInfoTextView.text = """
                        Food: ${item.name}
                        Calories: ${item.calories} kcal
                        Fat: ${item.fat_total_g} g
                        Protein: ${item.protein_g} g
                        Carbohydrates: ${item.carbohydrates_total_g} g
                    """.trimIndent()
                } else {
                    nutritionInfoTextView.text = "No nutritional information found."
                }
            } else {
                Toast.makeText(this@MainActivity, "Failed to retrieve data", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFailure(call: Call<NutritionResponse>, t: Throwable) {
            Toast.makeText(this@MainActivity, "Network error, please try again later.", Toast.LENGTH_SHORT).show()
        }
    })
}
}

