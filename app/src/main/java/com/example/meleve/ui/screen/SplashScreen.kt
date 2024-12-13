package com.example.meleve.ui.screen

import android.window.SplashScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.meleve.ui.theme.GreenBase
import com.example.meleve.ui.theme.GreenLight
import com.example.meleve.ui.theme.Typography
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(modifier: Modifier = Modifier, onNavigationToHome: () -> Unit) {

    LaunchedEffect(key1 = Unit) {
        delay(3000)
        onNavigationToHome()
    }

    Row(
        modifier = Modifier
            .background(GreenLight)
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "MeLeva", style = Typography.displayLarge.copy(fontWeight = FontWeight.Bold))
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen(onNavigationToHome = {})
}