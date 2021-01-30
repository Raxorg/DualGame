package com.frontanilla.dual.screens.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frontanilla.dual.screens.shared.gui.StretchableImage;
import com.frontanilla.dual.screens.shared.structure.Assets;

import static com.frontanilla.dual.Constants.CAMERA_HEIGHT;
import static com.frontanilla.dual.Constants.CAMERA_WIDTH;
import static com.frontanilla.dual.Constants.FRAME_THICKNESS;

public class SnakePanel {

    private final StretchableImage frame;
    private final Grid grid;

    public SnakePanel(Assets assets) {
        frame = new StretchableImage(assets.getPixel(), FRAME_THICKNESS);
        frame.setPosition(0, CAMERA_HEIGHT / 2 - FRAME_THICKNESS / 2);
        frame.setSize(CAMERA_WIDTH, CAMERA_HEIGHT / 2 + FRAME_THICKNESS / 2);
        frame.setCenterColor(Color.CLEAR);
        frame.setMarginColor(Color.BLACK);

        grid = new Grid(assets.getPixel());
    }

    public void draw(SpriteBatch spriteBatch) {
        frame.draw(spriteBatch);
        grid.draw(spriteBatch);
    }
}