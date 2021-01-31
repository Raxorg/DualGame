package com.frontanilla.dual.screens.game.stuff.snake;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.frontanilla.dual.Constants.CELL_SIZE;
import static com.frontanilla.dual.Constants.CELL_SPACING;
import static com.frontanilla.dual.Constants.DARK_GRASS;
import static com.frontanilla.dual.Constants.GRID_COLUMNS;
import static com.frontanilla.dual.Constants.GRID_HEIGHT;
import static com.frontanilla.dual.Constants.GRID_ROWS;
import static com.frontanilla.dual.Constants.GRID_WIDTH;
import static com.frontanilla.dual.Constants.GRID_X;
import static com.frontanilla.dual.Constants.GRID_Y;
import static com.frontanilla.dual.Constants.LIGHT_GRASS;

public class Grid {

    private final Sprite background;
    private final Cell[][] cells;

    public Grid(Sprite pixel) {
        background = new Sprite(pixel);
        background.setPosition(GRID_X, GRID_Y);
        background.setSize(GRID_WIDTH, GRID_HEIGHT);
        background.setColor(Color.BROWN);

        cells = new Cell[GRID_COLUMNS][];
        for (int column = 0; column < GRID_COLUMNS; column++) {
            cells[column] = new Cell[GRID_ROWS];
            for (int row = 0; row < GRID_ROWS; row++) {
                Cell cell = new Cell(pixel, column, row);
                cells[column][row] = cell;
                cell.setX(GRID_X + CELL_SPACING + CELL_SIZE * column + CELL_SPACING * column);
                cell.setY(GRID_Y + CELL_SPACING + CELL_SIZE * row + CELL_SPACING * row);
                cell.setColor((column + row) % 2 == 0 ? LIGHT_GRASS : DARK_GRASS);
            }
        }
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        for (int column = 0; column < GRID_COLUMNS; column++) {
            for (int row = 0; row < GRID_ROWS; row++) {
                cells[column][row].draw(spriteBatch);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }
}