package com.frontanilla.dual.screens.splash.logic;

import com.frontanilla.dual.screens.game.GameInitializer;
import com.frontanilla.dual.screens.shared.structure.Assets;
import com.frontanilla.dual.screens.shared.structure.Screen;

public class TransitionHandler {

    private Assets assets;
    private Screen screen;
    // Logic
    private float time;
    private boolean assetsInitialized;

    public void update(float delta) {
        time += delta;
        if (time >= 0f && assetsInitialized) {
            new GameInitializer().initialize(assets, screen);
        }
    }

    public void assetsInitialized() {
        assetsInitialized = true;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}