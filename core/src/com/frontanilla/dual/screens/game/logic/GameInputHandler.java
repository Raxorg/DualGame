package com.frontanilla.dual.screens.game.logic;

import com.badlogic.gdx.Input.Keys;
import com.frontanilla.dual.screens.shared.structure.Input;
import com.frontanilla.dual.screens.shared.structure.InputHandler;
import com.frontanilla.dual.screens.shared.structure.Screen;

public class GameInputHandler extends InputHandler {

    private Input input;
    private GameLogic logic;
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
        switch (keycode) {
            case Keys.W:
            case Keys.UP:
                logic.getSnakeHandler().upPressed();
                break;
            case Keys.S:
            case Keys.DOWN:
                logic.getSnakeHandler().downPressed();
                break;
            case Keys.D:
            case Keys.RIGHT:
                logic.getSnakeHandler().rightPressed();
                break;
            case Keys.A:
            case Keys.LEFT:
                logic.getSnakeHandler().leftPressed();
                break;
            case Keys.SPACE:
                logic.getRocketHandler().spacePressed();
                break;
        }
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}