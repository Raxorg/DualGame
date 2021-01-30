package com.frontanilla.dual.screens.splash.logic;

import com.frontanilla.dual.screens.shared.structure.Assets;

public class AssetLoader {

    private Assets assets;
    private SplashLogic logic;
    // Logic
    private boolean loadingAssets;

    public void queueAssetLoading() {
        assets.queueAssetLoading();
        loadingAssets = true;
    }

    public void update() {
        if (!loadingAssets) {
            return;
        }
        if (assets.loadAssets()) {
            assets.initializeAssets();
            logic.getTransitionHandler().assetsInitialized();
            loadingAssets = false;
        }
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public void setLogic(SplashLogic logic) {
        this.logic = logic;
    }
}