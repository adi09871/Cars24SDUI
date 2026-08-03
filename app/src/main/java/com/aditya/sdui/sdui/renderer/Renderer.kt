package com.aditya.sdui.sdui.renderer

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.aditya.sdui.data.model.ScreenModel
import com.aditya.sdui.sdui.registry.ComponentRegistry

import androidx.compose.ui.Modifier

@Composable
fun Renderer(screen: ScreenModel, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(screen.components) { component ->
            ComponentRegistry.RenderComponent(component)
        }
    }
}
