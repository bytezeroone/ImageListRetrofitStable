package com.example.newappretrofittest.data.remote.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class PokemonList(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String,
    @SerialName("previous")
    val previous: Any,
    @SerialName("results")
    val results: List<Result>
)