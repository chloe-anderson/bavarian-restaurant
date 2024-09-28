package com.example.bavarian_restaurant

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun MenuItemDetail(navController: NavController, id: Int) {
    //I want to display the detailed information for each menu item here
    val menu = getMenu()
    val dish = menu[id - 1]
    val context = LocalContext.current
    var topBarBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(topBarBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                // icon to go back to main page
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(Icons.Rounded.ArrowBack, contentDescription = "Arrow Back", tint = Color.White)
                    }
                },
                //title
                title = { Text("Back to Menu", fontSize = 20.sp) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(R.color.purple_500),
                    titleContentColor = Color.White,
                ),
                scrollBehavior = topBarBehavior
            )
        },
        content = { it ->
            Column(
                modifier = Modifier.padding(it)
                    .padding(horizontal = 25.dp, vertical = 15.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = dish.dishImage),
                    contentDescription = "Image of $dish as it would be served in a restaurant",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = dish.dishName,
                    fontSize = 34.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = dish.dishPronunciation, modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.height(10.dp))

                Text(text = dish.dishDetail,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

            }
        }
    )
}