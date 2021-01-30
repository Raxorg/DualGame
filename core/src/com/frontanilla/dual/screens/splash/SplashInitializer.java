package com.frontanilla.dual.screens.splash;

import com.frontanilla.dual.DualGame;
import com.frontanilla.dual.screens.shared.structure.Assets;
import com.frontanilla.dual.screens.shared.structure.Screen;
import com.frontanilla.dual.screens.splash.logic.SplashLogic;

public class SplashInitializer {

    public void initialize(DualGame game) {
        Assets assets = new Assets();
        SplashLogic logic = new SplashLogic();
        SplashRenderer renderer = new SplashRenderer();
        Screen screen = new Screen();

        logic.setAssets(assets);
        logic.setScreen(screen);
        screen.setLogic(logic);
        screen.setRenderer(renderer);

        logic.initialLogic();
        game.setScreen(screen);
    }
}