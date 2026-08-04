package com.aditya.sdui.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScreenResponse(
    val screen: ScreenModel
)

@Serializable
data class ScreenModel(
    val id: String,
    val version: String,
    val components: List<UIComponent>
)

@Serializable
sealed class UIComponent {
    abstract val type: String

    @Serializable
    @SerialName("header")
    data class Header(
        override val type: String = "header",
        val location: String,
        val profileIcon: String? = null
    ) : UIComponent()

    @Serializable
    @SerialName("search")
    data class Search(
        override val type: String = "search",
        val placeholder: String,
        val backgroundColor: String? = null
    ) : UIComponent()

    @Serializable
    @SerialName("icon_row")
    data class IconRow(
        override val type: String = "icon_row",
        val items: List<IconItem>,
        val backgroundColor: String? = null
    ) : UIComponent()

    @Serializable
    @SerialName("section")
    data class Section(
        override val type: String = "section",
        val title: String,
        val titleBadge: String? = null,
        val itemStyle: String = "default",
        val items: List<Item>
    ) : UIComponent()

    @Serializable
    @SerialName("tenure_selector")
    data class TenureSelector(
        override val type: String = "tenure_selector",
        val label: String,
        val options: List<String>,
        val selectedIndex: Int = 0
    ) : UIComponent()

    @Serializable
    @SerialName("unknown")
    data class Unknown(
        override val type: String = "unknown",
        val message: String? = null
    ) : UIComponent()

    @Serializable
    @SerialName("bottom_navigation")
    data class BottomNavigation(
        override val type: String = "bottom_navigation",
        val selectedIndex: Int,
        val items: List<NavigationItem>
    ) : UIComponent()
}

@Serializable
data class IconItem(
    val title: String,
    val icon: String,
    val isSelected: Boolean = false
)

@Serializable
data class Item(
    val id: String,
    val title: String,
    val subtitle: String? = null,
    val price: String? = null,
    val image: String? = null,
    val backgroundColor: String? = null
)

@Serializable
data class NavigationItem(
    val title: String,
    val icon: String
)
