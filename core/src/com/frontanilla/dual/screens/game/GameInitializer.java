package com.frontanilla.dual.screens.game;

import com.frontanilla.dual.screens.game.logic.GameLogic;
import com.frontanilla.dual.screens.game.stuff.GameStuff;
import com.frontanilla.dual.screens.shared.structure.Assets;
import com.frontanilla.dual.screens.shared.structure.Input;
import com.frontanilla.dual.screens.shared.structure.Screen;

public class GameInitializer {

    public void initialize(Assets assets, Input input, Screen screen) {
        GameLogic logic = new GameLogic();
        GameRenderer renderer = new GameRenderer();
        GameStuff stuff = new GameStuff();

        logic.setAssets(assets);
        logic.setInput(input);
        logic.setScreen(screen);
        logic.setStuff(stuff);
        renderer.setScreen(screen);
        renderer.setStuff(stuff);
        screen.setLogic(logic);
        screen.setRenderer(renderer);
        stuff.setAssets(assets);

        stuff.initializeStuff();

        logic.initialLogic();
    }
}