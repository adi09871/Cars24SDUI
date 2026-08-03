package com.aditya.sdui.data.parser

import android.content.Context
import com.aditya.sdui.data.model.ScreenResponse
import kotlinx.serialization.json.Json

class Parser(private val context: Context) {
    private val json = Json {
        ignoreUnknownKeys = true
        classDiscriminator = "type"
    }

    fun parseHomeJson(): ScreenResponse? {
        return try {
            val jsonString = context.assets.open("home_screen.json").bufferedReader().use { it.readText() }
            json.decodeFromString<ScreenResponse>(jsonString)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
