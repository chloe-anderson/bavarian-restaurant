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
                "A cheesy dish consisting of spätzle, typically served with either crispy onions or radishes for garnish." +
                        "Spätzle is a kind of Central European pasta, and the dish is sort of like mac and cheese.",
                R.drawable.k_sesp_tzle
            ),
            MenuItemModel(2, "Sauerbraten", "Marinated roast beef", "[ZOW-ur-BRA-ten]", "Roast beef marinated and cooked until tender." +
                    "Served with gravy. Pair with Semmelknödel for an excellent, hearty meal.", R.drawable.sauerbraten
            ),
            MenuItemModel(3, "Schweinshaxe", "Roasted pork knuckles", "[SHVINES-hack-suh]", "Roasted pork knuckles", R.drawable.schweinshaxe),
            MenuItemModel(4, "Semmelknödel", "Bread dumplings", "[ZEM-mul-KNO-dull]", "Traditional German dumplings made from bread rolls, " +
                    "cooked in milk with musk and other spices for seasoning.", R.drawable.semmelknoedel),
            MenuItemModel(5, "Linseneintopf", "Lentil stew", "[LIN-zun-INE-topf]", "A hearty stew made with lentils. Very filling.", R.drawable.linseneintopf),
            MenuItemModel(6, "Kaiserschmarrn", "Shredded waffle", "[KAI-zur-SHMARN]",
                "An Austrian dessert originally served to Emperor Ludwig, which quickly became his favorite meal. It is made of waffle, " +
                        "shredded with powdered sugar on top, and comes with apple compote to dip the waffle pieces in. " +
                        "The name translates to 'emperor's mess.'", R.drawable.kaiserschmarrn),
            MenuItemModel(7, "Gemischtes Eis", "Mixed ice cream", "[guh-MISH-tess ICE]", "Scoops of several different kinds of ice cream," +
                    "served together in the same bowl.", R.drawable.gemischtes)
        )
    }
    return menu
}