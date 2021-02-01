package com.frontanilla.dual.screens.splash.logic;

import com.frontanilla.dual.screens.game.GameInitializer;
import com.frontanilla.dual.screens.menu.MenuInitializer;
import com.frontanilla.dual.screens.shared.structure.Assets;
import com.frontanilla.dual.screens.shared.structure.Screen;
import com.frontanilla.dual.screens.splash.SplashStuff;

import static com.frontanilla.dual.Constants.SPLASH_MINIMUM_DURATION;

public class TransitionHandler {

    private Assets assets;
    private Screen screen;
    private SplashStuff stuff;
    // Logic
    private float time;
    private boolean assetsInitialized;

    public void update(float delta) {
        time += delta;
        if (time >= SPLASH_MINIMUM_DURATION && assetsInitialized) {
            stuff.dispose();
            new MenuInitializer().initialize(assets,screen);
            assets.getBackgroundMusic().setLooping(true);
            assets.getBackgroundMusic().play();
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

    public void setStuff(SplashStuff stuff) {
        this.stuff = stuff;
    }
}