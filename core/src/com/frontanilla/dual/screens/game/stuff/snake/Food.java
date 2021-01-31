package com.frontanilla.dual.screens.game.stuff.snake;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.frontanilla.dual.enums.FoodType;

import static com.frontanilla.dual.enums.ContentType.FOOD;

public abstract class Food extends CellContent {

    private final FoodType foodType;

    public Food(Cell cell, Sprite foodSprite, FoodType foodType) {
        super(cell, foodSprite, FOOD);
        this.foodType = foodType;
    }

    public FoodType getFoodType() {
        return foodType;
    }
}