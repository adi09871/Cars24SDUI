package com.aditya.sdui.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.aditya.sdui.data.model.UIComponent

@Composable
fun BottomNavComponent(nav: UIComponent.BottomNavigation) {
    NavigationBar {
        nav.items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == nav.selectedIndex,
                onClick = { /* Handle click */ },
                icon = { 

                    val imageVector = when(item.icon) {
                        "home" -> Icons.Default.Home
                        "history" -> Icons.Default.DateRange
                        "car_repair" -> Icons.Default.Build
                        "store" -> Icons.Default.Home
                        "explore" -> Icons.Default.Search
                        else -> Icons.Default.Info
                    }
                    Icon(imageVector, contentDescription = item.title)
                },
                label = { Text(item.title) }
            )
        }
    }
}
