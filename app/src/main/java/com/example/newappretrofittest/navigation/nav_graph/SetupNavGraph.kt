package com.example.pokedexyesanotherone.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.newappretrofittest.navigation.nav_graph.firstNavGraph

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "list_screen"
    ) {
        firstNavGraph()
    }
}