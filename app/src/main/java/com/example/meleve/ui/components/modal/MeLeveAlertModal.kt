package com.example.meleve.ui.components.modal

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.meleve.ui.theme.GreenBase
import com.example.meleve.ui.theme.RedBase

@Composable
fun MeLeveAlertModal(
    onDismissRequest: () -> Unit = {},
    onConfirmation: () -> Unit = {},
    onDismissTitle: String = "Fechar",
    onConfirmationTitle: String = "Confirmar",
    showDismissButton: Boolean = true,
    showConfirmationButton: Boolean = true,
    dialogTitle: String? = null,
    dialogText: String? = null,
    icon: ImageVector? = null,
) {
    AlertDialog(
        icon = {
            if (icon != null) Icon(icon, contentDescription = "Example Icon")

        },
        title = {
            if (dialogTitle != null) Text(text = dialogTitle)

        },
        text = {
            if (dialogText != null) Text(text = dialogText)

        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            if (showConfirmationButton)
            TextButton(
                onClick = {
                    onConfirmation()
                },
            ) {
                Text(onConfirmationTitle, color = GreenBase)
            }
        },
        dismissButton = {
            if (showDismissButton)
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text(onDismissTitle, color = RedBase)
            }
        }
    )
}

@Preview
@Composable
fun MeLeveAlertModalPreview() {
    MeLeveAlertModal(icon = Icons.Filled.Warning, dialogTitle = "My modal", dialogText = "lorem ipsum", )
}