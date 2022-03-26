package com.example.newappretrofittest.data.remote

import com.example.newappretrofittest.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {

    @GET("pokemon")
    suspend fun getImageList(
        @Query("limit") limit: Int,
        @Query ("offset") offset: Int
    ): PokemonList
}