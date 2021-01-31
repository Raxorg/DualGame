package com.frontanilla.dual.screens.game.stuff.snake;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.frontanilla.dual.Constants.CELL_SIZE;

public class Cell {

    private final Sprite cell;
    private final int column, row;
    private CellContent cellContent;

    public Cell(Sprite cellSprite, int column, int row) {
        cell = new Sprite(cellSprite);
        cell.setSize(CELL_SIZE, CELL_SIZE);
        this.column = column;
        this.row = row;
    }

    public void draw(SpriteBatch spriteBatch) {
        cell.draw(spriteBatch);
    }

    public int getX() {
        return (int) cell.getX();
    }

    public void setX(int x) {
        cell.setX(x);
    }

    public int getY() {
        return (int) cell.getY();
    }

    public void setY(int y) {
        cell.setY(y);
    }

    public void setColor(Color color) {
        cell.setColor(color);
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public CellContent getCellContent() {
        return cellContent;
    }

    public void setCellContent(CellContent cellContent) {
        this.cellContent = cellContent;
    }
}