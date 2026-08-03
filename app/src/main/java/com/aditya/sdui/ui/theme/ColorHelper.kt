package com.aditya.sdui.ui.theme

import androidx.compose.ui.graphics.Color

object ColorHelper {
    fun parse(hex: String?, default: Color = Color.Transparent): Color {
        if (hex == null) return default
        return try {
            Color(android.graphics.Color.parseColor(hex))
        } catch (e: Exception) {
            default
        }
    }
}
