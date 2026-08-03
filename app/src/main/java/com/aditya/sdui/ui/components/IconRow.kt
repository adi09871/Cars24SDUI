package com.aditya.sdui.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aditya.sdui.data.model.UIComponent
import com.aditya.sdui.ui.theme.ColorHelper

@Composable
fun IconRowComponent(iconRow: UIComponent.IconRow) {
    val bgColor = ColorHelper.parse(iconRow.backgroundColor, Color(0xFF3E41C1))
    
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(bgColor)
            .padding(vertical = 12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(iconRow.items) { item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(70.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(if (item.isSelected) Color.White else Color.White.copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                ) {
                    val icon = when (item.icon) {
                        "grid" -> Icons.Default.Menu
                        "car" -> Icons.Default.DirectionsCar
                        "sell" -> Icons.Default.AddCircle
                        "loan" -> Icons.Default.AccountBalance
                        "receipt" -> Icons.Default.ListAlt
                        else -> Icons.Default.Info
                    }
                    Icon(
                        imageVector = icon,
                        contentDescription = item.title,
                        tint = if (item.isSelected) Color(0xFF3E41C1) else Color.White,
                        modifier = Modifier.size(28.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = item.title,
                    color = Color.White,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 14.sp
                )
            }
        }
    }
}
