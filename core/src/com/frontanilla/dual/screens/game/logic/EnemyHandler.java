package com.frontanilla.dual.screens.game.logic;

import com.frontanilla.dual.screens.game.stuff.GameStuff;

import static com.frontanilla.dual.Constants.ENEMY_SPAWN_INTERVAL;

public class EnemyHandler {

    private GameStuff stuff;
    // Logic
    private float time;

    public void update(float delta) {
        time += delta;
        if (time >= ENEMY_SPAWN_INTERVAL) {
            spawnEnemy();
            time = 0f;
        }
    }

    private void spawnEnemy() {

    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}