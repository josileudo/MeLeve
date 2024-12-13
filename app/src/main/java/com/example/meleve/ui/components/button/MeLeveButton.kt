package com.example.meleve.ui.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meleve.ui.theme.Gray100
import com.example.meleve.ui.theme.GreenBase
import com.example.meleve.ui.theme.Typography
import com.google.maps.android.compose.Circle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeLeveButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    text: String? = null,
    iconRes: ImageVector? = null,
    isLoading: Boolean = false,
    size: String = "md"
) {
    val height = when(size) {
        "sm" -> 22.dp
        "md" -> 56.dp
        else -> 66.dp
    }
    val textSyle = when(size) {
        "sm" -> Typography.labelLarge.copy(fontSize = 10.sp)
        "md" -> Typography.labelLarge
        else -> Typography.labelLarge.copy(fontSize = 24.sp)
    }
    val iconSize = when(size) {
        "sm" -> 12.dp
        "md" -> 24.dp
        else -> 32.dp
    }
    Button(
        modifier = modifier.heightIn(min = height),
        enabled = !isLoading,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenBase,
        ),
        onClick = onClick,
        contentPadding = if(text == null && iconRes != null) PaddingValues(0.dp) else ButtonDefaults.ContentPadding
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            if(!isLoading) {
                iconRes?.let {
                    Icon(
                        iconRes,
                        contentDescription = "Button icon",
                        modifier = Modifier.height(iconSize)
                    )
                }
                text?.let {
                    Text(text = text.uppercase(), style = textSyle)
                }
            } else {
                CircularProgressIndicator(
                    modifier = Modifier.height(iconSize).aspectRatio(1f),
                    color = Gray100,
                )
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
fun MeLeveFormSmPreview() {
    MeLeveButton(
        modifier = Modifier.fillMaxWidth(),
        text = "Me leve",
        iconRes = Icons.Rounded.Done,
        size = "sm"
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

@Preview
@Composable
fun MeLeveFormIsLoadingPreview() {
    MeLeveButton(
        modifier = Modifier.fillMaxWidth(),
        iconRes = Icons.Rounded.ArrowBack,
        isLoading = true
    )
}
