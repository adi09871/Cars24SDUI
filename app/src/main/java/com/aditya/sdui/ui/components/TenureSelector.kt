package com.aditya.sdui.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aditya.sdui.data.model.UIComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TenureSelectorComponent(tenure: UIComponent.TenureSelector) {
    var showSheet by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableIntStateOf(tenure.selectedIndex) }
    val sheetState = rememberModalBottomSheetState()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { showSheet = true },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = tenure.label, style = MaterialTheme.typography.bodyLarge)
            Text(
                text = tenure.options.getOrNull(selectedIndex) ?: "Select",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = sheetState
        ) {
            Column(modifier = Modifier.padding(bottom = 32.dp)) {
                Text(
                    text = "Select Tenure",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleLarge
                )
                tenure.options.forEachIndexed { index, option ->
                    ListItem(
                        headlineContent = { Text(option) },
                        modifier = Modifier.clickable {
                            selectedIndex = index
                            showSheet = false
                        },
                        trailingContent = {
                            RadioButton(
                                selected = index == selectedIndex,
                                onClick = null
                            )
                        }
                    )
                }
            }
        }
    }
}
