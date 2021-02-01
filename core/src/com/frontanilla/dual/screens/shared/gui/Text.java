package com.frontanilla.dual.screens.shared.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.frontanilla.dual.utils.RenderUtils;

public class Text {

    private final BitmapFont font;
    private final Rectangle bounds;
    private String text;

    public Text(BitmapFont font) {
        this.font = font;
        bounds = new Rectangle();
        text = "";
    }

    public void draw(SpriteBatch spriteBatch) {
        RenderUtils.drawCentered(font, spriteBatch, text, bounds);
    }

    public void dispose() {
        font.dispose();
    }

    public void setPosition(float x, float y) {
        bounds.setPosition(x, y);
    }

    public void setSize(float width, float height) {
        bounds.setSize(width, height);
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return font.getColor();
    }

    public void setColor(Color color) {
        font.setColor(color);
    }
}