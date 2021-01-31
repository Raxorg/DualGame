package com.frontanilla.dual.screens.game.stuff.snake;

import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.frontanilla.dual.enums.ContentType.SNAKE;

public class SnakePart extends CellContent {

    private SnakePart nextPart;
    private Cell oldCell;
    private boolean exists;

    public SnakePart(Cell cell, Sprite partSprite) {
        super(cell, partSprite, SNAKE);
        exists = true;
    }

    public SnakePart nextPart() {
        return nextPart;
    }

    public void setNextPart(SnakePart nextPart) {
        this.nextPart = nextPart;
    }

    public Cell getOldCell() {
        return oldCell;
    }

    public void setOldCell(Cell oldCell) {
        this.oldCell = oldCell;
    }

    public boolean exists() {
        return exists;
    }

    public void disappear() {
        exists = false;
    }
}