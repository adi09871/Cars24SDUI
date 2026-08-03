package com.aditya.sdui.sdui.actions

sealed class Action {
    data class Navigate(val destination: String) : Action()
    data class ShowToast(val message: String) : Action()
}

interface ActionDispatcher {
    fun dispatch(action: Action)
}
