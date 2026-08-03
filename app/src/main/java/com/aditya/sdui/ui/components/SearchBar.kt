package com.aditya.sdui.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aditya.sdui.data.model.UIComponent
import com.aditya.sdui.ui.theme.ColorHelper

@Composable
fun SearchBarComponent(search: UIComponent.Search) {
    val bgColor = ColorHelper.parse(search.backgroundColor, Color(0xFF3E41C1))
    
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(bgColor)
            .padding(16.dp)
    ) {
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(text = search.placeholder, color = Color.LightGray) },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color.LightGray) },
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White.copy(alpha = 0.1f),
                unfocusedContainerColor = Color.White.copy(alpha = 0.1f),
                disabledContainerColor = Color.White.copy(alpha = 0.1f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            readOnly = true
        )
    }
}
