package com.aditya.sdui.sdui.registry

import androidx.compose.runtime.Composable
import com.aditya.sdui.data.model.UIComponent

import com.aditya.sdui.ui.components.HeaderComponent
import com.aditya.sdui.ui.components.SearchBarComponent
import com.aditya.sdui.ui.components.SectionComponent
import com.aditya.sdui.ui.components.BottomNavComponent
import com.aditya.sdui.ui.components.IconRowComponent
import com.aditya.sdui.ui.components.TenureSelectorComponent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object ComponentRegistry {
    @Composable
    fun RenderComponent(component: UIComponent) {
        when (component) {
            is UIComponent.Header -> HeaderComponent(component)
            is UIComponent.Search -> SearchBarComponent(component)
            is UIComponent.IconRow -> IconRowComponent(component)
            is UIComponent.Section -> SectionComponent(component)
            is UIComponent.TenureSelector -> TenureSelectorComponent(component)
            is UIComponent.BottomNavigation -> BottomNavComponent(component)
            is UIComponent.Unknown -> UnknownComponent(component.message ?: "Unknown Component")
            else -> UnknownComponent("Component ${component.type} not implemented")
        }
    }

    @Composable
    private fun UnknownComponent(message: String) {
        Text(
            text = message,
            color = Color.Red,
            modifier = Modifier.padding(16.dp)
        )
    }
}
