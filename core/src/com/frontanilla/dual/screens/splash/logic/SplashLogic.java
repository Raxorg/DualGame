package com.frontanilla.dual.screens.splash.logic;

import com.frontanilla.dual.screens.shared.structure.Assets;
import com.frontanilla.dual.screens.shared.structure.Logic;
import com.frontanilla.dual.screens.shared.structure.Screen;
import com.frontanilla.dual.screens.splash.SplashStuff;

public class SplashLogic extends Logic {

    private final AssetLoader assetLoader;
    private final TransitionHandler transitionHandler;

    public SplashLogic() {
        assetLoader = new AssetLoader();
        transitionHandler = new TransitionHandler();

        assetLoader.setLogic(this);
    }

    public void initialLogic() {
        assetLoader.queueAssetLoading();
    }

    @Override
    public void update(float delta) {
        assetLoader.update();
        transitionHandler.update(delta);
    }

    public void setAssets(Assets assets) {
        assetLoader.setAssets(assets);
        transitionHandler.setAssets(assets);
    }

    public void setScreen(Screen screen) {
        transitionHandler.setScreen(screen);
    }

    public void setStuff(SplashStuff stuff) {
        transitionHandler.setStuff(stuff);
    }

    public TransitionHandler getTransitionHandler() {
        return transitionHandler;
    }
}