package com.wildlifespotter.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Path
import com.wildlifespotter.data.remote.dto.RarityResponse

interface RarityApi {
    @GET("rarity/{speciesName}")
    suspend fun getRarity(@Path("speciesName") speciesName: String): RarityResponse
}