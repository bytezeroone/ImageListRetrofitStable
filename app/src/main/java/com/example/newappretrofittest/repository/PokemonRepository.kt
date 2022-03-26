package com.example.newappretrofittest.repository

import com.example.newappretrofittest.data.remote.ImageApi
import com.example.newappretrofittest.data.remote.responses.PokemonList
import com.example.newappretrofittest.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class ImageRepository @Inject constructor(
    private val api: ImageApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getImageList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }
}