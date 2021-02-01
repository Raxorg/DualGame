package com.frontanilla.dual.screens.game.logic;

import com.frontanilla.dual.screens.game.stuff.GameStuff;
import com.frontanilla.dual.screens.shared.structure.Assets;
import com.frontanilla.dual.screens.shared.structure.Input;
import com.frontanilla.dual.screens.shared.structure.Logic;
import com.frontanilla.dual.screens.shared.structure.Screen;

public class GameLogic extends Logic {

    private final CollisionHandler collisionHandler;
    private final EnemyHandler enemyHandler;
    private final FoodHandler foodHandler;
    private final GameInputHandler gameInputHandler;
    private final NatureHandler natureHandler;
    private final RobotHandler robotHandler;
    private final RocketHandler rocketHandler;
    private final SnakeHandler snakeHandler;

    public GameLogic() {
        collisionHandler = new CollisionHandler();
        enemyHandler = new EnemyHandler();
        foodHandler = new FoodHandler();
        gameInputHandler = new GameInputHandler();
        natureHandler = new NatureHandler();
        robotHandler = new RobotHandler();
        rocketHandler = new RocketHandler();
        snakeHandler = new SnakeHandler();

        collisionHandler.setLogic(this);
        gameInputHandler.setLogic(this);
        rocketHandler.setLogic(this);
        snakeHandler.setLogic(this);
    }

    public void initialLogic() {
        enemyHandler.configureEnemies();
        foodHandler.configureFood();
        gameInputHandler.configureInput();
        natureHandler.configureNature();
        robotHandler.configureRobot();
        snakeHandler.configureSnake();
    }

    @Override
    public void update(float delta) {
        collisionHandler.update();
        enemyHandler.update(delta);
        foodHandler.update(delta);
        natureHandler.update(delta);
        rocketHandler.update(delta);
        snakeHandler.update(delta);
    }

    // Structure
    public void setAssets(Assets assets) {
        enemyHandler.setAssets(assets);
        foodHandler.setAssets(assets);
        natureHandler.setAssets(assets);
        robotHandler.setAssets(assets);
        rocketHandler.setAssets(assets);
        snakeHandler.setAssets(assets);
    }

    public void setInput(Input input) {
        gameInputHandler.setInput(input);
    }

    public void setScreen(Screen screen) {
        gameInputHandler.setScreen(screen);
    }

    public void setStuff(GameStuff stuff) {
        collisionHandler.setStuff(stuff);
        enemyHandler.setStuff(stuff);
        foodHandler.setStuff(stuff);
        natureHandler.setStuff(stuff);
        robotHandler.setStuff(stuff);
        rocketHandler.setStuff(stuff);
        snakeHandler.setStuff(stuff);
    }

    // Helpers
    public RobotHandler getRobotHandler() {
        return robotHandler;
    }

    public RocketHandler getRocketHandler() {
        return rocketHandler;
    }

    public SnakeHandler getSnakeHandler() {
        return snakeHandler;
    }
}