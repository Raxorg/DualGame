package com.frontanilla.dual.screens.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Cell {

    private final Sprite cell;

    public Cell(Sprite cellSprite) {
        cell = new Sprite(cellSprite);
    }

    public void draw(SpriteBatch spriteBatch) {
        cell.draw(spriteBatch);
    }

    public void setX(int x) {
        cell.setX(x);
    }

    public void setY(int y) {
        cell.setY(y);
    }

    public void setSize(int size) {
        cell.setSize(size, size);
    }
}