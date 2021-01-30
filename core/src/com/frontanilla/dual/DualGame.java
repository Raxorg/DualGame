package com.frontanilla.dual;

import com.badlogic.gdx.Game;
import com.frontanilla.dual.screens.splash.SplashInitializer;

public class DualGame extends Game {

    @Override
    public void create() {
        new SplashInitializer().initialize(this);
    }
}