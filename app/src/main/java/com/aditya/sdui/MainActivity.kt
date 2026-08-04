package com.aditya.sdui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import com.aditya.sdui.data.parser.Parser
import com.aditya.sdui.ui.screens.HomeScreen
import com.aditya.sdui.ui.theme.Cars24SDUITheme

import androidx.activity.SystemBarStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(android.graphics.Color.TRANSPARENT)
        )
        setContent {
            Cars24SDUITheme {
                val parser = remember { Parser(this@MainActivity) }
                val screenResponse = remember { parser.parseHomeJson() }

                screenResponse?.screen?.let { screenModel ->
                    HomeScreen(screenModel)
                } ?: run {
                    Text(text = "Loading or Error loading screen")
                }
            }
        }
    }
}