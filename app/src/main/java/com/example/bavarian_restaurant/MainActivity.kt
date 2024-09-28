package com.example.bavarian_restaurant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bavarian_restaurant.ui.theme.BavarianRestaurantTheme


/*
 * Homework 4: Bavarian Restaurant
 * Developer: Chloe Anderson
 * Date: September 27, 2024
 * Version: Koala Feature Drop | 2024.1.2
 * OS: Ubuntu Linux 24.10
 * Description: This app allows the user to explore the typical offerings of a traditional Bavarian restaurant,
so that they can gain familiarity with the dishes and better appreciate Bavarian cuisine.
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BavarianRestaurantTheme() {
                MyNavigation()
            }
        }
    }
}

@Composable
fun MyNavigation() { //After Moving First page
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "RestaurantInterface") {
        composable("RestaurantInterface") {
            RestaurantInterface(navController = navController)
        }
        composable("MenuItemDetail/{id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
        ) {it->
            val dishId = it.arguments?.getInt("id")
            dishId?.let {dishId ->   //it parameter
                MenuItemDetail(navController = navController, id = dishId,)
            }
        }
    }


}