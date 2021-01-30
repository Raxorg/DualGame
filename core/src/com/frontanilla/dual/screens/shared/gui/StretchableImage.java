package com.frontanilla.dual.screens.shared.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class StretchableImage {

    private final Rectangle bounds;
    private Color marginColor, centerColor;
    private final Sprite center, corner, side;
    private final float margin;

    public StretchableImage(Sprite centerSprite, Sprite cornerSprite, Sprite sideSprite, float margin) {
        bounds = new Rectangle();
        marginColor = Color.WHITE;
        centerColor = Color.WHITE;
        center = new Sprite(centerSprite);
        corner = new Sprite(cornerSprite);
        side = new Sprite(sideSprite);
        this.margin = margin;
    }

    public StretchableImage(Sprite sprite, float margin) {
        this(sprite, sprite, sprite, margin);
    }

    public void draw(SpriteBatch batch) {
        batch.setColor(marginColor);
        // Bottom left Corner
        batch.draw(
                corner,
                bounds.x, bounds.y,
                margin, margin);
        // Left Side
        batch.draw(
                side,
                bounds.x, bounds.y + margin,
                margin, bounds.height - 2 * margin);
        // Top Left Corner
        batch.draw(
                corner,
                bounds.x, bounds.y + bounds.height - margin,
                margin / 2f, margin / 2f,
                margin, margin,
                1, 1, 270);
        // Top Side
        batch.draw(
                side,
                bounds.x + margin, bounds.y + bounds.height,
                0, 0,
                margin, bounds.width - 2 * margin,
                1, 1, 270);
        // Top Right Corner
        batch.draw(
                corner,
                bounds.x + bounds.width - margin, bounds.y + bounds.height - margin,
                margin / 2f, margin / 2f,
                margin, margin,
                1, 1, 180);
        // Right Side
        batch.draw(
                side,
                bounds.x + bounds.width, bounds.y + bounds.height - margin,
                0, 0,
                margin, bounds.height - 2 * margin,
                1, 1, 180);
        // Bottom Right Corner
        batch.draw(
                corner,
                bounds.x + bounds.width - margin, bounds.y,
                margin / 2f, margin / 2f,
                margin, margin,
                1, 1, 90);
        // Bottom Side
        batch.draw(
                side,
                bounds.x + bounds.width - margin, bounds.y,
                0, 0,
                margin, bounds.width - 2 * margin,
                1, 1, 90);
        // Center
        batch.setColor(centerColor);
        batch.draw(
                center,
                bounds.x + margin, bounds.y + margin,
                bounds.width - 2 * margin, bounds.height - 2 * margin);
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    public boolean contains(float x, float y) {
        return bounds.contains(x, y);
    }

    public float getX() {
        return bounds.x;
    }

    public float getY() {
        return bounds.y;
    }

    public void setPosition(int x, int y) {
        bounds.setPosition(x, y);
    }

    public float getWidth() {
        return bounds.width;
    }

    public float getHeight() {
        return bounds.height;
    }

    public void setSize(int width, int height) {
        bounds.setSize(width, height);
    }

    public void setMarginColor(Color color) {
        marginColor = color;
    }

    public void setCenterColor(Color color) {
        centerColor = color;
    }

    public float getMargin() {
        return margin;
    }
}