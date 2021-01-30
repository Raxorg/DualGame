package com.frontanilla.dual.screens.game.logic;

import com.frontanilla.dual.screens.game.stuff.GameStuff;
import com.frontanilla.dual.screens.game.stuff.Robot;
import com.frontanilla.dual.screens.shared.structure.Assets;

public class RobotHandler {

    private Assets assets;
    private GameStuff stuff;

    public void configureRobot() {
        assets.getMotor().loop(0.15f);
        Robot robot = stuff.getPlatformerPanel().getRobot();
        robot.setX(100);
    }

    public void update(float delta) {
        //todo
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}