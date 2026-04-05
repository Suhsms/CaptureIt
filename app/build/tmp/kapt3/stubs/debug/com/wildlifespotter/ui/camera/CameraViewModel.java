package com.wildlifespotter.ui.camera;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u000bR\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/wildlifespotter/ui/camera/CameraViewModel;", "Landroidx/lifecycle/ViewModel;", "identifySpeciesUseCase", "Lcom/wildlifespotter/domain/usecase/IdentifySpeciesUseCase;", "calculatePointsUseCase", "Lcom/wildlifespotter/domain/usecase/CalculatePointsUseCase;", "saveSightingUseCase", "Lcom/wildlifespotter/domain/usecase/SaveSightingUseCase;", "(Lcom/wildlifespotter/domain/usecase/IdentifySpeciesUseCase;Lcom/wildlifespotter/domain/usecase/CalculatePointsUseCase;Lcom/wildlifespotter/domain/usecase/SaveSightingUseCase;)V", "_identifiedSpecies", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_points", "", "identifiedSpecies", "Lkotlinx/coroutines/flow/StateFlow;", "getIdentifiedSpecies", "()Lkotlinx/coroutines/flow/StateFlow;", "points", "getPoints", "capturePhoto", "", "photo", "", "location", "onSpeciesIdentified", "speciesName", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class CameraViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.wildlifespotter.domain.usecase.IdentifySpeciesUseCase identifySpeciesUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.wildlifespotter.domain.usecase.CalculatePointsUseCase calculatePointsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.wildlifespotter.domain.usecase.SaveSightingUseCase saveSightingUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _identifiedSpecies = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> identifiedSpecies = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _points = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> points = null;
    
    @javax.inject.Inject()
    public CameraViewModel(@org.jetbrains.annotations.NotNull()
    com.wildlifespotter.domain.usecase.IdentifySpeciesUseCase identifySpeciesUseCase, @org.jetbrains.annotations.NotNull()
    com.wildlifespotter.domain.usecase.CalculatePointsUseCase calculatePointsUseCase, @org.jetbrains.annotations.NotNull()
    com.wildlifespotter.domain.usecase.SaveSightingUseCase saveSightingUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getIdentifiedSpecies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getPoints() {
        return null;
    }
    
    public final void onSpeciesIdentified(@org.jetbrains.annotations.NotNull()
    java.lang.String speciesName) {
    }
    
    public final void capturePhoto(@org.jetbrains.annotations.NotNull()
    byte[] photo, @org.jetbrains.annotations.NotNull()
    java.lang.String location) {
    }
}