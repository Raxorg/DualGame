package com.frontanilla.dual.screens.menu.logic;

import com.frontanilla.dual.screens.menu.MenuStuff;
import com.frontanilla.dual.screens.shared.structure.Input;
import com.frontanilla.dual.screens.shared.structure.InputHandler;
import com.frontanilla.dual.screens.shared.structure.Screen;

public class MenuInputHandler extends InputHandler {

    private Input input;
    private MenuLogic logic;
    private Screen screen;
    private MenuStuff stuff;

    public void configureInput() {
        input.setInputHandler(this);
        input.setCamera(screen.getCamera());
        input.setEnabled(true);
    }

    @Override
    public void touchDown(float x, float y) {
        if (stuff.getPlayButton().contains(x, y)) {
            stuff.getPlayButton().useSprite2();
        }
        if (stuff.getTutorialButton().contains(x, y)) {
            stuff.getTutorialButton().useSprite2();
        }
        if (stuff.getCreditsButton().contains(x, y)) {
            stuff.getCreditsButton().useSprite2();
        }
    }

    @Override
    public void touchUp(float x, float y) {
        logic.getMenuHandler().deselectButtons();
        if (stuff.getPlayButton().contains(x, y)) {
            logic.getMenuHandler().playButtonPressed();
            return;
        }
        if (stuff.getTutorialButton().contains(x, y)) {
            logic.getMenuHandler().tutorialButtonPressed();
            return;
        }
        if (stuff.getCreditsButton().contains(x, y)) {
            logic.getMenuHandler().creditsButtonPressed();
            return;
        }
        logic.getMenuHandler().touchUp();
    }

    @Override
    public void keyDown(int keycode) {

    }

    public void setInput(Input input) {
        this.input = input;
    }

    public void setLogic(MenuLogic logic) {
        this.logic = logic;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setStuff(MenuStuff stuff) {
        this.stuff = stuff;
    }
}