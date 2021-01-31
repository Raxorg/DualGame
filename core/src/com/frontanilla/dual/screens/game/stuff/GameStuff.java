package com.frontanilla.dual.screens.game.stuff;

import com.frontanilla.dual.screens.game.stuff.robot.RobotPanel;
import com.frontanilla.dual.screens.game.stuff.snake.SnakePanel;
import com.frontanilla.dual.screens.shared.structure.Assets;

public class GameStuff {

    private Assets assets;
    // Stuff
    private SnakePanel snakePanel;
    private RobotPanel robotPanel;

    public void initializeStuff() {
        snakePanel = new SnakePanel(assets);
        robotPanel = new RobotPanel(assets);
    }

    public SnakePanel getSnakePanel() {
        return snakePanel;
    }

    public RobotPanel getRobotPanel() {
        return robotPanel;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }
}