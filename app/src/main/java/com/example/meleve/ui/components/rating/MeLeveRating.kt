package com.example.meleve.ui.components.rating

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meleve.ui.theme.GreenBase

@Composable
fun MeLeveRating(
    modifier: Modifier = Modifier,
    maxRating: Int = 5,
    rating: Int = 0,
) {
    val unFilledStars = maxRating - rating
    val icon = if(unFilledStars > 0) Icons.Default.Star else Icons.Default.Star
    Row(modifier = modifier)  {
        repeat(rating) {
            Icon(icon, contentDescription = "Star", tint = GreenBase, modifier = modifier)
        }

        repeat(unFilledStars) {
            Icon(icon, contentDescription = "Star")
        }
    }
}

@Preview
@Composable
private fun MeLeveRatingPreview() {
    MeLeveRating(rating = 1)
}