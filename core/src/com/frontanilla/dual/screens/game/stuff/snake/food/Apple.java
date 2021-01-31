package com.frontanilla.dual.screens.game.stuff.snake.food;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.frontanilla.dual.screens.game.stuff.snake.Cell;
import com.frontanilla.dual.screens.game.stuff.snake.Food;

import static com.frontanilla.dual.enums.FoodType.APPLE;

public class Apple extends Food {

    public Apple(Cell cell, Sprite appleSprite) {
        super(cell, appleSprite, APPLE);
    }
}