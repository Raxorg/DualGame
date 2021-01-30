package com.frontanilla.dual.screens.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.frontanilla.dual.Constants.CELL_SIZE;
import static com.frontanilla.dual.Constants.CELL_SPACING;
import static com.frontanilla.dual.Constants.GRID_COLUMNS;
import static com.frontanilla.dual.Constants.GRID_ROWS;
import static com.frontanilla.dual.Constants.GRID_X;
import static com.frontanilla.dual.Constants.GRID_Y;

public class Grid {

    private final Cell[][] cells;

    public Grid(Sprite cellSprite) {
        cells = new Cell[GRID_COLUMNS][];
        for (int column = 0; column < GRID_COLUMNS; column++) {
            cells[column] = new Cell[GRID_ROWS];
            for (int row = 0; row < GRID_ROWS; row++) {
                Cell cell = new Cell(cellSprite);
                cells[column][row] = cell;
                cell.setX(GRID_X + CELL_SPACING + CELL_SIZE * column + CELL_SPACING * column);
                cell.setY(GRID_Y + CELL_SPACING + CELL_SIZE * row + CELL_SPACING * row);
                cell.setSize(CELL_SIZE);
            }
        }
    }

    public void draw(SpriteBatch spriteBatch) {
        for (int column = 0; column < GRID_COLUMNS; column++) {
            for (int row = 0; row < GRID_ROWS; row++) {
                cells[column][row].draw(spriteBatch);
            }
        }
    }
}