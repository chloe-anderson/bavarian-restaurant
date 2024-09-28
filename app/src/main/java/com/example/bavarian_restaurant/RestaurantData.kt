package com.example.bavarian_restaurant

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList

@Composable
fun getMenu() : SnapshotStateList<MenuItemModel> {
    val menu = remember {
        mutableStateListOf(
            MenuItemModel(
                1,
                "Käsespätzle",
                "Cheesy Spätzle",
                "[KAY-zuh-SHPET-sluh]",
                "A cheesy dish consisting of spätzle, a type of pasta, " +
                        "typically served with either crispy onions or radishes for garnish.",

                R.drawable.k_sesp_tzle
            ),
            MenuItemModel(2, ""
            )
        )
    }
    return menu
}