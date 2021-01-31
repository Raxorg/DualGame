package com.frontanilla.dual.screens.shared.structure;

public abstract class InputHandler {

    public abstract void touchDown(float x, float y);

    public abstract void touchUp(float x, float y);

    public abstract void keyDown(int keycode);
}