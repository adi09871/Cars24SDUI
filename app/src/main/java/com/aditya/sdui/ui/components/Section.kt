package com.aditya.sdui.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aditya.sdui.data.model.Item
import com.aditya.sdui.data.model.UIComponent
import com.aditya.sdui.ui.theme.ColorHelper

@Composable
fun SectionComponent(section: UIComponent.Section) {
    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = section.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            section.titleBadge?.let {
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .background(Color.Red, shape = RoundedCornerShape(12.dp))
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(text = it, color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        when (section.itemStyle) {
            "colored" -> {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(section.items) { item ->
                        ColoredCard(item)
                    }
                }
            }
            "circular" -> {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(section.items) { item ->
                        CircularItem(item)
                    }
                }
            }
            "grid" -> {
                // For simplicity, using a Row of columns or just LazyRow for now
                // Real implementation might use Vertical grid or multi-row LazyRow
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    section.items.chunked(2).forEach { rowItems ->
                        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            rowItems.forEach { item ->
                                GridCard(item, Modifier.weight(1f))
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
            else -> {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(section.items) { item ->
                        DefaultCard(item)
                    }
                }
            }
        }
    }
}

@Composable
fun ColoredCard(item: Item) {
    val bgColor = ColorHelper.parse(item.backgroundColor, Color.Gray)
    Card(
        modifier = Modifier.size(width = 160.dp, height = 110.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = item.title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(12.dp),
                fontSize = 14.sp
            )
            // Placeholder for image at bottom
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(80.dp)
                    .background(Color.White.copy(alpha = 0.1f), RoundedCornerShape(topStart = 40.dp))
            )
        }
    }
}

@Composable
fun CircularItem(item: Item) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(100.dp)) {
        Box(
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
                .background(Color.LightGray.copy(alpha = 0.3f)),
            contentAlignment = Alignment.Center
        ) {
            Text("IMG", color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.title, fontSize = 12.sp, textAlign = androidx.compose.ui.text.style.TextAlign.Center)
    }
}

@Composable
fun GridCard(item: Item, modifier: Modifier = Modifier) {
    val bgColor = ColorHelper.parse(item.backgroundColor, Color(0xFFFFF9C4))
    Card(
        modifier = modifier.height(100.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor)
    ) {
        Row(modifier = Modifier.fillMaxSize().padding(12.dp)) {
            Text(
                text = item.title,
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Medium,
                fontSize = 13.sp
            )
            Box(modifier = Modifier.size(50.dp).background(Color.White.copy(alpha = 0.5f), CircleShape))
        }
    }
}

@Composable
fun DefaultCard(item: Item) {
    Card(modifier = Modifier.width(150.dp)) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = item.title)
        }
    }
}
