package com.example.meleve

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meleve.ui.screen.HomeScreen
import com.example.meleve.ui.screen.Route.Home
import com.example.meleve.ui.screen.Route.Splash
import com.example.meleve.ui.screen.Route.TvlOptions
import com.example.meleve.ui.screen.SplashScreen
import com.example.meleve.ui.screen.TravelOptions
import com.example.meleve.ui.theme.MeLeveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MeLeveTheme() {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Splash
                ) {
                    composable<Splash> {
                        SplashScreen(
                            onNavigationToHome = {
                                navController.navigate(Home)
                            }
                        )
                    }

                    composable<Home> {
                        HomeScreen(onNavigationToTravelOptions = {
                            navController.navigate(TvlOptions)
                        })
                    }

                    composable<TvlOptions> {
                        TravelOptions()
                    }
                }
            }
        }
    }
}
