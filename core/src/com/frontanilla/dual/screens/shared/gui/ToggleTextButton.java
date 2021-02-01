package com.frontanilla.dual.screens.shared.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ToggleTextButton extends ToggleSprite {

    private final Text text;
    private Color textColor1, textColor2, currentColor;

    public ToggleTextButton(Sprite sprite1, Sprite sprite2, BitmapFont font, Color textColor1, Color textColor2) {
        super(sprite1, sprite2);
        text = new Text(font);
        this.textColor1 = textColor1;
        this.textColor2 = textColor2;
        currentColor = textColor1;
    }

    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
        Color previousColor = text.getColor();
        text.setColor(currentColor);
        text.draw(spriteBatch);
        text.setColor(previousColor);
    }

    @Override
    public void useSprite1() {
        super.useSprite1();
        currentColor = textColor1;
    }

    @Override
    public void useSprite2() {
        super.useSprite2();
        currentColor = textColor2;
    }

    @Override
    public void swapSprites() {
        super.swapSprites();
        Color temp = textColor1.cpy();
        textColor1 = textColor2.cpy();
        textColor2 = temp;
        currentColor = textColor1;
    }

    public void setText(String text) {
        this.text.setText(text);
    }

    public void setX(float x) {
        super.setX(x);
        text.setPosition(x, getY());
    }

    public void setY(float y) {
        super.setY(y);
        text.setPosition(getX(), y);
    }

    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        text.setPosition(x, y);
    }

    public void setSize(float width, float height) {
        super.setSize(width, height);
        text.setSize(width, height);
    }
}