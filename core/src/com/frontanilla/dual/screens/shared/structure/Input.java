package com.frontanilla.dual.screens.shared.structure;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class Input extends InputAdapter {

    private InputHandler inputHandler;
    private OrthographicCamera camera;
    private Vector3 unprojected;
    private boolean enabled;

    public Input() {
        unprojected = new Vector3();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (!enabled) {
            return false;
        }
        unprojected = camera.unproject(new Vector3(screenX, screenY, 0f));
        inputHandler.touchDown(unprojected.x, unprojected.y);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (!enabled) {
            return false;
        }
        unprojected = camera.unproject(new Vector3(screenX, screenY, 0f));
        inputHandler.touchUp(unprojected.x, unprojected.y);
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (!enabled) {
            return false;
        }
        inputHandler.keyDown(keycode);
        return true;
    }

    public void setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}