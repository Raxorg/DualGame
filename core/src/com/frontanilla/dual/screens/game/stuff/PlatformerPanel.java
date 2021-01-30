package com.frontanilla.dual.screens.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.dual.screens.shared.gui.StretchableImage;
import com.frontanilla.dual.screens.shared.structure.Assets;

import static com.frontanilla.dual.Constants.FRAME_HEIGHT;
import static com.frontanilla.dual.Constants.FRAME_THICKNESS;
import static com.frontanilla.dual.Constants.FRAME_WIDTH;

public class PlatformerPanel {

    private final DelayedRemovalArray<Sprite> groundTiles;
    private final DelayedRemovalArray<Sprite> backgroundNature, foregroundNature;
    private final Robot robot;
    private final StretchableImage frame;

    public PlatformerPanel(Assets assets) {
        groundTiles = new DelayedRemovalArray<>();
        backgroundNature = new DelayedRemovalArray<>();
        foregroundNature = new DelayedRemovalArray<>();

        robot = new Robot(assets.getRobot());

        frame = new StretchableImage(assets.getPixel(), FRAME_THICKNESS);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setCenterColor(Color.CLEAR);
        frame.setMarginColor(Color.BLACK);
    }

    public void draw(SpriteBatch spriteBatch) {
        for (int i = 0; i < groundTiles.size; i++) {
            groundTiles.get(i).draw(spriteBatch);
        }
        for (int i = 0; i < backgroundNature.size; i++) {
            backgroundNature.get(i).draw(spriteBatch);
        }
        robot.draw(spriteBatch);
        for (int i = 0; i < foregroundNature.size; i++) {
            foregroundNature.get(i).draw(spriteBatch);
        }
        frame.draw(spriteBatch);
    }

    public DelayedRemovalArray<Sprite> getGroundTiles() {
        return groundTiles;
    }

    public DelayedRemovalArray<Sprite> getBackgroundNature() {
        return backgroundNature;
    }

    public DelayedRemovalArray<Sprite> getForegroundNature() {
        return foregroundNature;
    }

    public Robot getRobot() {
        return robot;
    }
}