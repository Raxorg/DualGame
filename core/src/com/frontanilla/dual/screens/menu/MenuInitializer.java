package com.frontanilla.dual.screens.menu;

import com.frontanilla.dual.screens.menu.logic.MenuLogic;
import com.frontanilla.dual.screens.shared.structure.Assets;
import com.frontanilla.dual.screens.shared.structure.Input;
import com.frontanilla.dual.screens.shared.structure.Screen;

public class MenuInitializer {

    public void initialize(Assets assets, Screen screen) {
        Input input = new Input();
        MenuLogic logic = new MenuLogic();
        MenuRenderer renderer = new MenuRenderer();
        MenuStuff stuff = new MenuStuff();

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