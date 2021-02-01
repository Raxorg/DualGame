package com.frontanilla.dual.screens.menu.logic;

import com.frontanilla.dual.screens.game.GameInitializer;
import com.frontanilla.dual.screens.shared.structure.Assets;
import com.frontanilla.dual.screens.shared.structure.Input;
import com.frontanilla.dual.screens.shared.structure.Screen;

public class TransitionHandler {

    private Assets assets;
    private Input input;
    private Screen screen;

    public void enterGameScreen() {
        new GameInitializer().initialize(assets, input, screen);
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}