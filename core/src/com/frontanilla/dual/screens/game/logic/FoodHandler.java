package com.frontanilla.dual.screens.game.logic;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.dual.enums.FoodType;
import com.frontanilla.dual.screens.game.stuff.GameStuff;
import com.frontanilla.dual.screens.game.stuff.snake.Cell;
import com.frontanilla.dual.screens.game.stuff.snake.Food;
import com.frontanilla.dual.screens.game.stuff.snake.food.Apple;
import com.frontanilla.dual.screens.game.stuff.snake.food.BadApple;
import com.frontanilla.dual.screens.game.stuff.snake.food.Screw;
import com.frontanilla.dual.screens.shared.structure.Assets;

import static com.frontanilla.dual.Constants.APPLES_PER_SPAWN;
import static com.frontanilla.dual.Constants.BAD_APPLES_PER_SPAWN;
import static com.frontanilla.dual.Constants.FOOD_SPAWN_INTERVAL;
import static com.frontanilla.dual.Constants.GRID_COLUMNS;
import static com.frontanilla.dual.Constants.GRID_ROWS;
import static com.frontanilla.dual.Constants.SCREWS_PER_SPAWN;
import static com.frontanilla.dual.enums.FoodType.APPLE;
import static com.frontanilla.dual.enums.FoodType.BAD_APPLE;
import static com.frontanilla.dual.enums.FoodType.SCREW;

public class FoodHandler {

    private Assets assets;
    private GameStuff stuff;
    // Logic
    private float time;

    public void configureFood() {
        time = 0f;
        spawnFoods();
    }

    public void update(float delta) {
        time += delta;
        if (time >= FOOD_SPAWN_INTERVAL) {
            clearFoods();
            spawnFoods();
        }
    }

    private void clearFoods() {
        DelayedRemovalArray<Food> foods = stuff.getSnakePanel().getFoods();
        foods.begin();
        for (int i = 0; i < foods.size; i++) {
            foods.get(i).getCell().setCellContent(null);
            foods.removeValue(foods.get(i), true);
        }
        foods.end();
    }

    private void spawnFoods() {
        for (int i = 0; i < APPLES_PER_SPAWN; i++) {
            spawnFood(APPLE);
        }
        for (int i = 0; i < SCREWS_PER_SPAWN; i++) {
            spawnFood(SCREW);
        }
        for (int i = 0; i < BAD_APPLES_PER_SPAWN; i++) {
            spawnFood(BAD_APPLE);
        }
        time = 0f;
    }

    private void spawnFood(FoodType foodType) {
        Cell randomCell;
        Cell[][] cells = stuff.getSnakePanel().getGrid().getCells();
        do {
            int randomColumn = MathUtils.random(0, GRID_COLUMNS - 1);
            int randomRow = MathUtils.random(0, GRID_ROWS - 1);
            randomCell = cells[randomColumn][randomRow];
        } while (randomCell.getCellContent() != null);
        Food food = null;
        switch (foodType) {
            case APPLE:
                food = new Apple(randomCell, assets.getApple());
                break;
            case SCREW:
                food = new Screw(randomCell, assets.getScrew());
                break;
            case BAD_APPLE:
                food = new BadApple(randomCell, assets.getBadApple());
                break;
        }
        stuff.getSnakePanel().getFoods().add(food);
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}