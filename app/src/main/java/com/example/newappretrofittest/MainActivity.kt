package com.example.newappretrofittest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.newappretrofittest.ui.theme.NewAppRetrofitTestTheme
import com.example.pokedexyesanotherone.navigation.nav_graph.SetupNavGraph
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewAppRetrofitTestTheme {
                // A surface container using the 'background' color from the theme
                    val navController = rememberNavController()
                    SetupNavGraph(navController = navController)
            }
        }
    }
}

