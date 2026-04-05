package com.wildlifespotter.domain.usecase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\f\u0010\rJ$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0013"}, d2 = {"Lcom/wildlifespotter/domain/usecase/IdentifySpeciesUseCase;", "", "speciesRepository", "Lcom/wildlifespotter/data/repository/SpeciesRepository;", "speciesClassifier", "Lcom/wildlifespotter/ml/SpeciesClassifier;", "(Lcom/wildlifespotter/data/repository/SpeciesRepository;Lcom/wildlifespotter/ml/SpeciesClassifier;)V", "execute", "Lkotlin/Result;", "Lcom/wildlifespotter/domain/model/Species;", "image", "", "execute-gIAlu-s", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeWithBitmap", "bitmap", "Landroid/graphics/Bitmap;", "executeWithBitmap-gIAlu-s", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class IdentifySpeciesUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.wildlifespotter.data.repository.SpeciesRepository speciesRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.wildlifespotter.ml.SpeciesClassifier speciesClassifier = null;
    
    @javax.inject.Inject()
    public IdentifySpeciesUseCase(@org.jetbrains.annotations.NotNull()
    com.wildlifespotter.data.repository.SpeciesRepository speciesRepository, @org.jetbrains.annotations.NotNull()
    com.wildlifespotter.ml.SpeciesClassifier speciesClassifier) {
        super();
    }
}