package com.frontanilla.dual.screens.game.stuff.snake.food;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.frontanilla.dual.screens.game.stuff.snake.Cell;
import com.frontanilla.dual.screens.game.stuff.snake.Food;

import static com.frontanilla.dual.enums.FoodType.SCREW;

public class Screw extends Food {

    public Screw(Cell cell, Sprite foodSprite) {
        super(cell, foodSprite, SCREW);
    }
}