package com.frontanilla.dual.screens.game.stuff.snake;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.dual.enums.Direction;

public class Snake {

    private final DelayedRemovalArray<SnakePart> parts;
    private Direction direction;

    public Snake(Cell startingCell, Sprite headSprite) {
        parts = new DelayedRemovalArray<>();
        SnakePart head = new SnakePart(startingCell, headSprite);
        parts.add(head);
    }

    public void draw(SpriteBatch spriteBatch) {
        for (int i = 0; i < parts.size; i++) {
            parts.get(i).draw(spriteBatch);
        }
    }

    public SnakePart getHead() {
        return parts.get(0);
    }

    public SnakePart getTail() {
        return parts.get(parts.size - 1);
    }

    public DelayedRemovalArray<SnakePart> getParts() {
        return parts;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}