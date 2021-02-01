package com.frontanilla.dual.screens.menu.logic;

import com.frontanilla.dual.screens.menu.MenuStuff;
import com.frontanilla.dual.screens.shared.structure.Assets;
import com.frontanilla.dual.screens.shared.structure.Input;
import com.frontanilla.dual.screens.shared.structure.Logic;
import com.frontanilla.dual.screens.shared.structure.Screen;

public class MenuLogic extends Logic {

    private final MenuHandler menuHandler;
    private final MenuInputHandler menuInputHandler;

    public MenuLogic() {
        menuHandler = new MenuHandler();
        menuInputHandler = new MenuInputHandler();

        menuInputHandler.setLogic(this);
    }

    public void initialLogic() {
        menuHandler.configureMenu();
        menuInputHandler.configureInput();
    }

    @Override
    public void update(float delta) {

    }

    // Structure
    public void setAssets(Assets assets) {
        menuHandler.setAssets(assets);
    }
    public void setInput(Input input) {
        menuHandler.setInput(input);
        menuInputHandler.setInput(input);
    }

    public void setScreen(Screen screen) {
        menuHandler.setScreen(screen);
        menuInputHandler.setScreen(screen);
    }

    public void setStuff(MenuStuff stuff) {
        menuHandler.setStuff(stuff);
        menuInputHandler.setStuff(stuff);
    }

    // Helpers
    public MenuHandler getMenuHandler() {
        return menuHandler;
    }
}