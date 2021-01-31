package com.frontanilla.dual.screens.game.stuff.snake.food;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.frontanilla.dual.screens.game.stuff.snake.Cell;
import com.frontanilla.dual.screens.game.stuff.snake.Food;

import static com.frontanilla.dual.enums.FoodType.BAD_APPLE;

public class BadApple extends Food {

    public BadApple(Cell cell, Sprite foodSprite) {
        super(cell, foodSprite, BAD_APPLE);
    }
}