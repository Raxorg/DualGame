package com.frontanilla.dual.screens.game.logic;

import com.frontanilla.dual.screens.shared.structure.Input;
import com.frontanilla.dual.screens.shared.structure.InputHandler;
import com.frontanilla.dual.screens.shared.structure.Screen;

public class GameInputHandler extends InputHandler {

    private Input input;
    private Screen screen;

    public void configureInput() {
        input.setInputHandler(this);
        input.setCamera(screen.getCamera());
        input.setEnabled(true);
    }

    @Override
    public void touchDown(float x, float y) {

    }

    @Override
    public void touchUp(float x, float y) {

    }

    @Override
    public void keyDown(int keycode) {

    }

    @Override
    public void keyUp(int keycode) {

    }

    public void setInput(Input input) {
        this.input = input;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}