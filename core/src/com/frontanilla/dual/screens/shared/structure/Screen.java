package com.frontanilla.dual.screens.shared.structure;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;

import static com.frontanilla.dual.Constants.CAMERA_HEIGHT;
import static com.frontanilla.dual.Constants.CAMERA_WIDTH;

public class Screen extends ScreenAdapter {

    private Logic logic;
    private Renderer renderer;
    // Screen related
    private final OrthographicCamera camera;

    public Screen() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT);
    }

    @Override
    public void render(float delta) {
        logic.update(delta);
        renderer.render();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setLogic(Logic logic) {
        this.logic = logic;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }
}