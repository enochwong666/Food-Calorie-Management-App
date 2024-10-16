package com.example.assignment2

import androidx.compose.foundation.layout.*
import android.widget.Toast
import androidx.benchmark.perfetto.ExperimentalPerfettoTraceProcessorApi
import androidx.benchmark.perfetto.Row
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalPerfettoTraceProcessorApi::class)
@Composable
fun FoodItem(food: Food){
    val context = LocalContext.current
    Card(onClick = {
        Toast.makeText(context,
            "${food.id} is clicked", Toast.LENGTH_SHORT).show()
    },
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Column (
                modifier = Modifier.padding(8.dp),
            ){
                Text(text = "Food ID: ${food.id.toString()}")
                Text(text = "Food Name: ${food.name}")
                Text(text = "Portion Size: ${food.portionSize.toString()}")
                Text(text = "Meal Type: ${food.mealType.toString()}")
                Text(text = "Number of Calories: ${food.numOfCal.toString()}")
            }
        }
    }
}

@Preview
@Composable
fun FoodItemView(){
    FoodItem(food = Food(id = 1, name = "brownies", portionSize = 20, mealType = "dessert", numOfCal = 93))
}

