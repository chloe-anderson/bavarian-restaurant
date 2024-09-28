package com.example.bavarian_restaurant

import android.widget.Toast
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantInterface(navController: NavController) {
    val menu = getMenu()
    val context = LocalContext.current
    var topBarBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(topBarBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("Your Guide to a Bavarian Restaurant", fontSize = 20.sp) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(R.color.purple_500),
                    titleContentColor = Color.White,
                ),
                scrollBehavior = topBarBehavior
            )
        },
        content = { it ->
            LazyColumn(
                modifier = Modifier.padding(it)
            ) {
                items(
                    count = menu.size,
                    itemContent = { index ->
                        val dish = menu[index]
                        //card
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                                .padding(8.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = colorResource(id = R.color.light_gray)
                            ),
                            shape = RoundedCornerShape(10.dp),
                            elevation = CardDefaults.cardElevation(8.dp),
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            )
                            {
                                Row(verticalAlignment = Alignment.CenterVertically)
                                {
                                    Image(
                                        painter = painterResource(dish.dishImage),
                                        contentDescription = dish.dishName,
                                        modifier = Modifier
                                            .size(80.dp)
                                            .clip(RoundedCornerShape(100)),
                                        contentScale = ContentScale.Crop,
                                        alignment = Alignment.Center
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            dish.dishName,
                                            fontSize = 20.sp,
                                            color = Color.Black
                                        )
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text(
                                            dish.dishTranslation,
                                            fontSize = 16.sp,
                                            color = Color.Black
                                        )
                                    }

                                }//2222222
                                Button(
                                    onClick = {
                                        navController.navigate("MenuItemDetail/${dish.dishID}")
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                                ) {
                                    Icon(
                                        Icons.Rounded.ArrowForward,
                                        contentDescription = "${dish.dishName}",
                                        tint = Color.Gray
                                    )
                                }
                            }
                        }

                    }
                )
            }
        }
    )
}