package com.frontanilla.dual.screens.game.stuff.robot;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.frontanilla.dual.Constants.FULL_BAR;
import static com.frontanilla.dual.Constants.ROBOT_BAR_BAR_OFFSET;
import static com.frontanilla.dual.Constants.ROBOT_BAR_HEIGHT;
import static com.frontanilla.dual.Constants.ROBOT_BAR_ICON_SIZE;
import static com.frontanilla.dual.Constants.ROBOT_BAR_MARGIN;

public class RobotBar {

    private final Sprite background;
    private final Sprite icon, filler, topLayer;

    public RobotBar(Sprite iconSprite, Sprite fillerSprite, Sprite topLayerSprite, Color color) {
        background = new Sprite(fillerSprite);
        background.setSize(ROBOT_BAR_ICON_SIZE, ROBOT_BAR_ICON_SIZE);
        background.setColor(color.cpy().lerp(Color.WHITE, 0.5f));
        icon = new Sprite(iconSprite);
        filler = new Sprite(fillerSprite);
        filler.setSize(0f, ROBOT_BAR_HEIGHT);
        filler.setColor(color);
        topLayer = new Sprite(topLayerSprite);
        setFullness(FULL_BAR);
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        icon.draw(spriteBatch);
        filler.draw(spriteBatch);
        topLayer.draw(spriteBatch);
    }

    public void setPosition(int x, int y) {
        background.setPosition(x, y);
        icon.setPosition(x, y);
        filler.setPosition(x + ROBOT_BAR_BAR_OFFSET + ROBOT_BAR_MARGIN, y);
        topLayer.setPosition(x + ROBOT_BAR_BAR_OFFSET, y);
    }


    public int getFullness() {
        return (int) filler.getWidth();
    }

    public void setFullness(int newFullness) {
        filler.setSize(newFullness, ROBOT_BAR_HEIGHT);
    }
}