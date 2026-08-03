package com.aditya.sdui.ui.screens

import androidx.compose.runtime.Composable
import com.aditya.sdui.sdui.renderer.Renderer
import com.aditya.sdui.data.model.ScreenModel

import androidx.compose.material3.Scaffold
import com.aditya.sdui.ui.components.BottomNavComponent
import com.aditya.sdui.data.model.UIComponent
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(screenModel: ScreenModel) {
    val bottomNav = screenModel.components.find { it is UIComponent.BottomNavigation } as? UIComponent.BottomNavigation
    val otherComponents = screenModel.components.filter { it !is UIComponent.BottomNavigation }

    Scaffold(
        bottomBar = {
            bottomNav?.let { BottomNavComponent(it) }
        }
    ) { padding ->
        Renderer(screenModel.copy(components = otherComponents), modifier = Modifier.padding(padding))
    }
}
