package com.frontanilla.dual.screens.shared.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ToggleSprite {

    private Sprite sprite1, sprite2, currentSprite;

    public ToggleSprite(Sprite sprite1, Sprite sprite2) {
        this.sprite1 = new Sprite(sprite1);
        this.sprite2 = new Sprite(sprite2);
        currentSprite = this.sprite1;
    }

    public ToggleSprite(Sprite sprite1, Sprite sprite2, Color color1, Color color2) {
        this.sprite1 = new Sprite(sprite1);
        this.sprite1.setColor(color1);
        this.sprite2 = new Sprite(sprite2);
        this.sprite2.setColor(color2);
        currentSprite = this.sprite1;
    }

    public boolean contains(float x, float y) {
        return currentSprite.getBoundingRectangle().contains(x, y);
    }

    public void useSprite1() {
        currentSprite = sprite1;
    }

    public void useSprite2() {
        currentSprite = sprite2;
    }

    public void swapSprites() {
        Sprite temp = sprite1;
        sprite1 = sprite2;
        sprite2 = temp;
        currentSprite = currentSprite == sprite1 ? sprite2 : sprite1;
    }

    public void toggle() {
        if (currentSprite == sprite1) {
            currentSprite = sprite2;
        } else {
            currentSprite = sprite1;
        }
    }

    public void draw(SpriteBatch spriteBatch) {
        currentSprite.draw(spriteBatch);
    }

    public void flip() {
        sprite1.flip(true, false);
        sprite2.flip(true, false);
    }

    public void setColor(Color color) {
        sprite1.setColor(color);
        sprite2.setColor(color);
    }

    public void setColor(float r, float g, float b, float a) {
        sprite1.setColor(r, g, b, a);
        sprite2.setColor(r, g, b, a);
    }

    public void setSprite1Color(Color color) {
        sprite1.setColor(color);
    }

    public void setSprite1Color(float r, float g, float b, float a) {
        sprite1.setColor(r, g, b, a);
    }

    public float getX() {
        return currentSprite.getX();
    }

    public void setX(float x) {
        sprite1.setX(x);
        sprite2.setX(x);
    }

    public float getY() {
        return currentSprite.getY();
    }

    public void setY(float y) {
        sprite1.setY(y);
        sprite2.setY(y);
    }

    public void setPosition(float x, float y) {
        sprite1.setPosition(x, y);
        sprite2.setPosition(x, y);
    }

    public float getWidth() {
        return currentSprite.getWidth();
    }

    public float getHeight() {
        return currentSprite.getHeight();
    }

    public void setSize(float size) {
        setSize(size, size);
    }

    public void setSize(float width, float height) {
        sprite1.setSize(width, height);
        sprite2.setSize(width, height);
    }
}