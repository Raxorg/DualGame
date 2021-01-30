package com.frontanilla.dual.screens.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.frontanilla.dual.Constants.PLATFORM_Y;

public class Robot {

    private final Sprite robot;

    public Robot(Sprite robotSprite) {
        robot = new Sprite(robotSprite);
        robot.setY(PLATFORM_Y);
    }

    public void draw(SpriteBatch spriteBatch) {
        robot.draw(spriteBatch);
    }

    public void setX(int x) {
        robot.setX(x);
    }
}