package com.frontanilla.dual.screens.game.stuff.robot;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.dual.screens.shared.gui.StretchableImage;
import com.frontanilla.dual.screens.shared.structure.Assets;

import static com.badlogic.gdx.graphics.Color.RED;
import static com.frontanilla.dual.Constants.AMMO_BAR_X;
import static com.frontanilla.dual.Constants.FRAME_HEIGHT;
import static com.frontanilla.dual.Constants.FRAME_THICKNESS;
import static com.frontanilla.dual.Constants.FRAME_WIDTH;
import static com.frontanilla.dual.Constants.HEALTH_BAR_X;
import static com.frontanilla.dual.Constants.NICE_BLUE;
import static com.frontanilla.dual.Constants.ROBOT_BAR_Y;

public class RobotPanel {

    private final DelayedRemovalArray<Sprite> groundTiles;
    private final DelayedRemovalArray<Sprite> backgroundNature, foregroundNature;
    private final RobotBar healthBar, ammoBar;
    private final Robot robot;
    private final DelayedRemovalArray<Sprite> rockets;
    private final StretchableImage frame;

    public RobotPanel(Assets assets) {
        groundTiles = new DelayedRemovalArray<>();
        backgroundNature = new DelayedRemovalArray<>();
        foregroundNature = new DelayedRemovalArray<>();

        healthBar = new RobotBar(assets.getHeart(), assets.getPixel(), assets.getBarTopLayer(), RED);
        healthBar.setPosition(HEALTH_BAR_X, ROBOT_BAR_Y);

        ammoBar = new RobotBar(assets.getRocket(), assets.getPixel(), assets.getBarTopLayer(), NICE_BLUE);
        ammoBar.setPosition(AMMO_BAR_X, ROBOT_BAR_Y);

        robot = new Robot(assets.getRobot());

        rockets = new DelayedRemovalArray<>();

        frame = new StretchableImage(assets.getPixel(), FRAME_THICKNESS);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setCenterColor(Color.CLEAR);
        frame.setMarginColor(Color.BLACK);
    }

    public void draw(SpriteBatch spriteBatch) {
        healthBar.draw(spriteBatch);
        ammoBar.draw(spriteBatch);
        for (int i = 0; i < groundTiles.size; i++) {
            groundTiles.get(i).draw(spriteBatch);
        }
        for (int i = 0; i < backgroundNature.size; i++) {
            backgroundNature.get(i).draw(spriteBatch);
        }
        robot.draw(spriteBatch);
        for (int i = 0; i < rockets.size; i++) {
            rockets.get(i).draw(spriteBatch);
        }
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

    public RobotBar getHealthBar() {
        return healthBar;
    }

    public RobotBar getAmmoBar() {
        return ammoBar;
    }

    public Robot getRobot() {
        return robot;
    }

    public DelayedRemovalArray<Sprite> getRockets() {
        return rockets;
    }
}