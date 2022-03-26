package com.example.newappretrofittest.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.newappretrofittest.ui.detail_screen.DetailScreen
import com.example.newappretrofittest.ui.pokemon_list_screen.PokemonListScreen

fun NavGraphBuilder.firstNavGraph(
) {
    composable("list_screen") {
        PokemonListScreen()
    }
    composable(
        "detail_screen/{dominantColor}/{pokemonName}",
        arguments = listOf(
            navArgument("dominantColor") {
                type = NavType.IntType
            },
            navArgument("pokemonName") {
                type = NavType.StringType
            }
        )
    ) {
        /*val dominantColor = remember {
            val color = it.arguments?.getInt("dominantColor")
            color?.let { Color(it) } ?: Color.White
        }
        val pokemonName = remember {
            it.arguments?.getString("pokemonName")
        }*/
        DetailScreen(
            /*dominantColor = dominantColor,
            pokemonName = pokemonName?.lowercase(Locale.ROOT) ?: "",
            navController = navController*/
        )
    }
}