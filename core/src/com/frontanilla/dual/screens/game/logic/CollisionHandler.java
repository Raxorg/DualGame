package com.frontanilla.dual.screens.game.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.dual.screens.game.stuff.GameStuff;
import com.frontanilla.dual.screens.game.stuff.robot.Robot;

import static com.frontanilla.dual.Constants.ENEMY_DAMAGE;

public class CollisionHandler {

    private GameLogic logic;
    private GameStuff stuff;

    public void update() {
        DelayedRemovalArray<Sprite> enemies = stuff.getRobotPanel().getEnemies();
        DelayedRemovalArray<Sprite> rockets = stuff.getRobotPanel().getRockets();
        enemies.begin();
        rockets.begin();
        for (int i = 0; i < enemies.size; i++) {
            Sprite enemy = enemies.get(i);
            // Against robot
            Robot robot = stuff.getRobotPanel().getRobot();
            if (enemy.getBoundingRectangle().overlaps(robot.getBounds())) {
                enemies.removeValue(enemy, true);
                logic.getRobotHandler().loseHealth(ENEMY_DAMAGE);
                break;
            }
            // Against rockets
            for (int j = 0; j < rockets.size; j++) {
                Sprite rocket = rockets.get(j);
                if (enemy.getBoundingRectangle().overlaps(rocket.getBoundingRectangle())) {
                    enemies.removeValue(enemy, true);
                    rockets.removeValue(rocket, true);
                    break;
                }
            }
        }
        enemies.end();
        rockets.end();
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}