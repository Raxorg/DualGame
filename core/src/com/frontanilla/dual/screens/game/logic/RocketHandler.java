package com.frontanilla.dual.screens.game.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.dual.screens.game.stuff.GameStuff;
import com.frontanilla.dual.screens.game.stuff.robot.RobotBar;
import com.frontanilla.dual.screens.shared.structure.Assets;

import static com.frontanilla.dual.Constants.CAMERA_WIDTH;
import static com.frontanilla.dual.Constants.FULLNESS_UNIT;
import static com.frontanilla.dual.Constants.ROCKET_SPEED;
import static com.frontanilla.dual.Constants.ROCKET_X;
import static com.frontanilla.dual.Constants.ROCKET_Y;

public class RocketHandler {

    private Assets assets;
    private GameLogic logic;
    private GameStuff stuff;

    public void spacePressed() {
        RobotBar ammoBar = stuff.getRobotPanel().getAmmoBar();
        if (ammoBar.getFullness() >= FULLNESS_UNIT) {
            fireRocket();
            logic.getRobotHandler().loseRocket();
        }
    }

    private void fireRocket() {
        DelayedRemovalArray<Sprite> rockets = stuff.getRobotPanel().getRockets();
        Sprite rocket = new Sprite(assets.getFiredRocket());
        rocket.setPosition(ROCKET_X, ROCKET_Y);
        rockets.add(rocket);
        assets.getRocketLaunch().play(0.25f);
    }

    public void update(float delta) {
        DelayedRemovalArray<Sprite> rockets = stuff.getRobotPanel().getRockets();
        rockets.begin();
        for (int i = 0; i < rockets.size; i++) {
            Sprite rocket = rockets.get(i);
            rocket.translateX(ROCKET_SPEED * delta);
            if (rocket.getX() >= CAMERA_WIDTH) {
                rockets.removeValue(rocket, true);
            }
        }
        rockets.end();
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