package com.example.meleve.ui.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meleve.ui.theme.GreenBase
import com.example.meleve.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeLeveButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    text: String? = null,
    iconRes: ImageVector? = null
) {
    Button(
        modifier = modifier.heightIn(min = 56.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenBase,
        ),
        onClick = onClick,
        contentPadding = if(text == null && iconRes != null) PaddingValues(0.dp) else ButtonDefaults.ContentPadding
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            iconRes?.let {
                Icon(iconRes, contentDescription = "Button icon")
            }
            text?.let {
                Text(text = text.uppercase(), style = Typography.labelLarge)
            }
        }
    }
}

@Preview
@Composable
fun MeLeveFormPreview() {
    MeLeveButton(
        modifier = Modifier.fillMaxWidth(),
        text = "Me leve",
        iconRes = Icons.Rounded.Done
    )
}

@Preview
@Composable
fun MeLeveFormNoTextPreview() {
    MeLeveButton(
        modifier = Modifier,
        iconRes = Icons.Rounded.ArrowBack
    )
}
