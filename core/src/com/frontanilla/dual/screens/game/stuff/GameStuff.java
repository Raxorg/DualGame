package com.frontanilla.dual.screens.game.stuff;

import com.frontanilla.dual.screens.game.stuff.robot.RobotPanel;
import com.frontanilla.dual.screens.game.stuff.snake.SnakePanel;
import com.frontanilla.dual.screens.shared.gui.Text;
import com.frontanilla.dual.screens.shared.structure.Assets;

import static com.frontanilla.dual.Constants.SCORE_X;
import static com.frontanilla.dual.Constants.SCORE_Y;

public class GameStuff {

    private Assets assets;
    // Stuff
    private SnakePanel snakePanel;
    private RobotPanel robotPanel;
    private Text score;

    public void initializeStuff() {
        snakePanel = new SnakePanel(assets);
        robotPanel = new RobotPanel(assets);
        score = new Text(assets.getPixelFont());
        score.setPosition(SCORE_X, SCORE_Y);
        score.setText("0");
    }

    public SnakePanel getSnakePanel() {
        return snakePanel;
    }

    public RobotPanel getRobotPanel() {
        return robotPanel;
    }

    public Text getScore() {
        return score;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }
}