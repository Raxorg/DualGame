package com.frontanilla.dual.screens.game.logic;

import com.frontanilla.dual.screens.game.stuff.GameStuff;
import com.frontanilla.dual.screens.game.stuff.robot.RobotBar;
import com.frontanilla.dual.screens.shared.structure.Assets;

import static com.frontanilla.dual.Constants.FULLNESS_UNIT;
import static com.frontanilla.dual.Constants.FULL_BAR;

public class RobotHandler {

    private Assets assets;
    private GameStuff stuff;

    public void configureRobot() {
        assets.getMotor().loop(0.2f);
        stuff.getRobotPanel().getHealthBar().setFullness(FULL_BAR);
        stuff.getRobotPanel().getAmmoBar().setFullness(FULL_BAR);
    }

    public void addHealth(int amount) {
        RobotBar healthBar = stuff.getRobotPanel().getHealthBar();
        int fullness = Math.min(healthBar.getFullness() + amount, FULL_BAR);
        healthBar.setFullness(fullness);
    }

    public void loseHealth(int amount) {
        RobotBar healthBar = stuff.getRobotPanel().getHealthBar();
        int fullness = Math.max(healthBar.getFullness() - amount, 0);
        healthBar.setFullness(fullness);
    }

    public void addRocket() {
        RobotBar ammoBar = stuff.getRobotPanel().getAmmoBar();
        int fullness = Math.min(ammoBar.getFullness() + FULLNESS_UNIT, FULL_BAR);
        ammoBar.setFullness(fullness);
    }

    public void loseRocket() {
        RobotBar ammoBar = stuff.getRobotPanel().getAmmoBar();
        int fullness = Math.max(ammoBar.getFullness() - FULLNESS_UNIT, 0);
        ammoBar.setFullness(fullness);
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}