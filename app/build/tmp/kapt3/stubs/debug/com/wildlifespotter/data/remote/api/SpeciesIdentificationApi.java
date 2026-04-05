package com.wildlifespotter.data.remote.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/wildlifespotter/data/remote/api/SpeciesIdentificationApi;", "", "identifySpecies", "Lcom/wildlifespotter/data/remote/dto/IdentificationResponse;", "image", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface SpeciesIdentificationApi {
    
    @retrofit2.http.POST(value = "identify")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object identifySpecies(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    byte[] image, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wildlifespotter.data.remote.dto.IdentificationResponse> $completion);
}