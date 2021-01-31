package com.frontanilla.dual.screens.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.dual.screens.game.stuff.GameStuff;
import com.frontanilla.dual.screens.game.stuff.snake.Cell;
import com.frontanilla.dual.screens.game.stuff.snake.CellContent;
import com.frontanilla.dual.screens.game.stuff.snake.Food;
import com.frontanilla.dual.screens.game.stuff.snake.Snake;
import com.frontanilla.dual.screens.game.stuff.snake.SnakePart;
import com.frontanilla.dual.screens.shared.structure.Assets;

import static com.frontanilla.dual.Constants.APPLE_HEALING;
import static com.frontanilla.dual.Constants.BAD_APPLE_DAMAGE;
import static com.frontanilla.dual.Constants.CANNIBALISM_DAMAGE;
import static com.frontanilla.dual.Constants.GRID_COLUMNS;
import static com.frontanilla.dual.Constants.GRID_ROWS;
import static com.frontanilla.dual.Constants.STARTING_COLUMN;
import static com.frontanilla.dual.Constants.STARTING_ROW;
import static com.frontanilla.dual.enums.Direction.DOWN;
import static com.frontanilla.dual.enums.Direction.LEFT;
import static com.frontanilla.dual.enums.Direction.RIGHT;
import static com.frontanilla.dual.enums.Direction.UP;

public class SnakeHandler {

    private Assets assets;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private float time, movementInterval;

    public void configureSnake() {
        Cell startingCell = stuff.getSnakePanel().getGrid().getCells()[STARTING_COLUMN][STARTING_ROW];
        Snake snake = stuff.getSnakePanel().getSnake();
        snake.getHead().setCell(startingCell);
        snake.setDirection(RIGHT);
        time = 0f;
        movementInterval = 1f;
    }

    public void update(float delta) {
        time += delta;
        if (time >= movementInterval) {
            Cell nextCell = calculateNextCell();
            checkNextCell(nextCell);
            moveSnake(nextCell);
            time = 0f;
        }
    }

    public void upPressed() {
        Snake snake = stuff.getSnakePanel().getSnake();
        if (snake.getDirection() == DOWN) {
            return;
        }
        snake.setDirection(UP);
        Cell nextCell = calculateNextCell();
        checkNextCell(nextCell);
        moveSnake(nextCell);
        time = 0f;
    }

    public void downPressed() {
        Snake snake = stuff.getSnakePanel().getSnake();
        if (snake.getDirection() == UP) {
            return;
        }
        snake.setDirection(DOWN);
        Cell nextCell = calculateNextCell();
        checkNextCell(nextCell);
        moveSnake(nextCell);
        time = 0f;
    }

    public void rightPressed() {
        Snake snake = stuff.getSnakePanel().getSnake();
        if (snake.getDirection() == LEFT) {
            return;
        }
        snake.setDirection(RIGHT);
        Cell nextCell = calculateNextCell();
        checkNextCell(nextCell);
        moveSnake(nextCell);
        time = 0f;
    }

    public void leftPressed() {
        Snake snake = stuff.getSnakePanel().getSnake();
        if (snake.getDirection() == RIGHT) {
            return;
        }
        snake.setDirection(LEFT);
        Cell nextCell = calculateNextCell();
        checkNextCell(nextCell);
        moveSnake(nextCell);
        time = 0f;
    }

    private Cell calculateNextCell() {
        Snake snake = stuff.getSnakePanel().getSnake();
        Cell currentCell = snake.getHead().getCell();
        Cell[][] cells = stuff.getSnakePanel().getGrid().getCells();
        Cell nextCell = null;
        switch (snake.getDirection()) {
            case UP:
                nextCell = obtainUpCell(currentCell, cells);
                break;
            case DOWN:
                nextCell = obtainDownCell(currentCell, cells);
                break;
            case RIGHT:
                nextCell = obtainRightCell(currentCell, cells);
                break;
            case LEFT:
                nextCell = obtainLeftCell(currentCell, cells);
                break;
        }
        return nextCell;
    }

    private Cell obtainUpCell(Cell currentCell, Cell[][] cells) {
        int newRow = currentCell.getRow() == GRID_ROWS - 1 ? 0 : currentCell.getRow() + 1;
        return cells[currentCell.getColumn()][newRow];
    }

    private Cell obtainDownCell(Cell currentCell, Cell[][] cells) {
        int newRow = currentCell.getRow() == 0 ? GRID_ROWS - 1 : currentCell.getRow() - 1;
        return cells[currentCell.getColumn()][newRow];
    }

    private Cell obtainRightCell(Cell currentCell, Cell[][] cells) {
        int newColumn = currentCell.getColumn() == GRID_COLUMNS - 1 ? 0 : currentCell.getColumn() + 1;
        return cells[newColumn][currentCell.getRow()];
    }

    private Cell obtainLeftCell(Cell currentCell, Cell[][] cells) {
        int newColumn = currentCell.getColumn() == 0 ? GRID_COLUMNS - 1 : currentCell.getColumn() - 1;
        return cells[newColumn][currentCell.getRow()];
    }

    private void checkNextCell(Cell nextCell) {
        CellContent cellContent = nextCell.getCellContent();
        if (cellContent == null) {
            return;
        }
        switch (cellContent.getContentType()) {
            case FOOD:
                eatFood((Food) cellContent);
                break;
            case SNAKE:
                eatSnake((SnakePart) cellContent);
                break;
        }
    }

    private void eatFood(Food food) {
        switch (food.getFoodType()) {
            case APPLE:
                growSnake();
                logic.getRobotHandler().addHealth(APPLE_HEALING);
                break;
            case SCREW:
                logic.getRobotHandler().addRocket();
                break;
            case BAD_APPLE:
                logic.getRobotHandler().loseHealth(BAD_APPLE_DAMAGE);
                break;
        }
        DelayedRemovalArray<Food> foods = stuff.getSnakePanel().getFoods();
        foods.begin();
        foods.removeValue(food, true);
        foods.end();
        movementInterval = Math.max(movementInterval - 0.05f, 0.1f);
    }

    private void growSnake() {
        Snake snake = stuff.getSnakePanel().getSnake();
        SnakePart newPart = new SnakePart(snake.getTail().getCell(), assets.getSnakeBody());
        snake.getTail().setNextPart(newPart);
        DelayedRemovalArray<SnakePart> snakeParts = snake.getParts();
        snakeParts.add(newPart);
    }

    private void eatSnake(SnakePart snakePart) {
        Snake snake = stuff.getSnakePanel().getSnake();
        if (snakePart == snake.getTail()) {
            return;
        }
        DelayedRemovalArray<SnakePart> snakeParts = stuff.getSnakePanel().getSnake().getParts();
        snakeParts.begin();
        SnakePart nextPart = snakePart.nextPart();
        while (nextPart != null) {
            nextPart.getCell().setCellContent(null);
            nextPart.disappear();
            snakeParts.removeValue(nextPart, true);
            nextPart = nextPart.nextPart();
            logic.getRobotHandler().loseHealth(CANNIBALISM_DAMAGE);
        }
        snakeParts.end();
    }

    public void moveSnake(Cell newCell) {
        Snake snake = stuff.getSnakePanel().getSnake();
        snake.getHead().setOldCell(snake.getHead().getCell());
        snake.getHead().setCell(newCell);
        SnakePart snakePart = snake.getHead();
        SnakePart nextPart = snakePart.nextPart();
        while (nextPart != null && nextPart.exists()) {
            nextPart.setOldCell(nextPart.getCell());
            nextPart.setCell(snakePart.getOldCell());
            snakePart = nextPart;
            nextPart = snakePart.nextPart();
        }
        snake.getHead().setCell(newCell);
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}