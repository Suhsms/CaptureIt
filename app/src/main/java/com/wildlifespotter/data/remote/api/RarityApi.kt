package com.wildlifespotter.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Path

interface RarityApi {
    @GET("rarity/{speciesName}")
    suspend fun getRarity(@Path("speciesName") speciesName: String): RarityResponse
}