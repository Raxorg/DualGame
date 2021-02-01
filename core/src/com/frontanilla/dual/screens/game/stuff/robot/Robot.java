package com.frontanilla.dual.screens.game.stuff.robot;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import static com.frontanilla.dual.Constants.PLATFORM_Y;
import static com.frontanilla.dual.Constants.ROBOT_X;

public class Robot {

    private final Sprite robot;

    public Robot(Sprite robotSprite) {
        robot = new Sprite(robotSprite);
        robot.setPosition(ROBOT_X, PLATFORM_Y);
    }

    public void draw(SpriteBatch spriteBatch) {
        robot.draw(spriteBatch);
    }

    public Rectangle getBounds() {
        return robot.getBoundingRectangle();
    }
}