package com.frontanilla.dual.screens.game.stuff.snake;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.dual.screens.shared.gui.StretchableImage;
import com.frontanilla.dual.screens.shared.structure.Assets;

import static com.frontanilla.dual.Constants.CAMERA_HEIGHT;
import static com.frontanilla.dual.Constants.DARK_DIRT;
import static com.frontanilla.dual.Constants.FRAME_HEIGHT;
import static com.frontanilla.dual.Constants.FRAME_THICKNESS;
import static com.frontanilla.dual.Constants.FRAME_WIDTH;
import static com.frontanilla.dual.Constants.STARTING_COLUMN;
import static com.frontanilla.dual.Constants.STARTING_ROW;

public class SnakePanel {

    private final StretchableImage frame;
    private final Grid grid;
    private final DelayedRemovalArray<Food> foods;
    private final Snake snake;

    public SnakePanel(Assets assets) {
        frame = new StretchableImage(assets.getPixel(), FRAME_THICKNESS);
        frame.setPosition(0, CAMERA_HEIGHT / 2 - FRAME_THICKNESS / 2);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setCenterColor(DARK_DIRT);
        frame.setMarginColor(Color.BLACK);

        grid = new Grid(assets.getPixel());

        foods = new DelayedRemovalArray<>();

        Cell startingCell = grid.getCells()[STARTING_COLUMN][STARTING_ROW];
        snake = new Snake(startingCell, assets.getSnakeHead());
    }

    public void draw(SpriteBatch spriteBatch) {
        frame.draw(spriteBatch);
        grid.draw(spriteBatch);
        for (int i = 0; i < foods.size; i++) {
            foods.get(i).draw(spriteBatch);
        }
        snake.draw(spriteBatch);
    }

    public Grid getGrid() {
        return grid;
    }

    public DelayedRemovalArray<Food> getFoods() {
        return foods;
    }

    public Snake getSnake() {
        return snake;
    }
}