package com.wildlifespotter;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = WildlifeSpotterApp.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface WildlifeSpotterApp_GeneratedInjector {
  void injectWildlifeSpotterApp(WildlifeSpotterApp wildlifeSpotterApp);
}
