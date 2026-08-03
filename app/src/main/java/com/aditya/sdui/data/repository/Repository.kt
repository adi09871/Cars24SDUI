package com.aditya.sdui.data.repository

import com.aditya.sdui.data.model.ScreenResponse
import com.aditya.sdui.data.parser.Parser

class Repository(private val parser: Parser) {
    fun getHomeScreen(): ScreenResponse? {
        return parser.parseHomeJson()
    }
}
