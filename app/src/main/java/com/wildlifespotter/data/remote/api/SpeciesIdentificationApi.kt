package com.wildlifespotter.data.remote.api

import retrofit2.http.Body
import retrofit2.http.POST
import com.wildlifespotter.data.remote.dto.IdentificationResponse

interface SpeciesIdentificationApi {
    @POST("identify")
    suspend fun identifySpecies(@Body image: ByteArray): IdentificationResponse
}