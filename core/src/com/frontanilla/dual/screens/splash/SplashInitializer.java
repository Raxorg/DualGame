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
        SplashStuff stuff = new SplashStuff();

        logic.setAssets(assets);
        logic.setScreen(screen);
        logic.setStuff(stuff);
        renderer.setScreen(screen);
        renderer.setStuff(stuff);
        screen.setLogic(logic);
        screen.setRenderer(renderer);

        stuff.initializeStuff();
        logic.initialLogic();

        game.setScreen(screen);
    }
}