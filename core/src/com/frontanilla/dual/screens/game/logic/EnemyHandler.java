package com.frontanilla.dual.screens.game.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.dual.screens.game.stuff.GameStuff;
import com.frontanilla.dual.screens.shared.structure.Assets;

import static com.frontanilla.dual.Constants.CAMERA_WIDTH;
import static com.frontanilla.dual.Constants.ENEMY_SPEED;
import static com.frontanilla.dual.Constants.PLATFORM_Y;

public class EnemyHandler {

    private Assets assets;
    private GameStuff stuff;
    // Logic
    private float time, spawnInterval;

    public void configureEnemies() {
        time = 0f;
        spawnInterval = MathUtils.random(1f, 5f);
    }

    public void update(float delta) {
        time += delta;
        if (time >= spawnInterval) {
            spawnEnemy();
            time = 0f;
            spawnInterval = MathUtils.random(1f, 9f);
        }
        moveEnemies(delta);
    }

    private void spawnEnemy() {
        Sprite enemy = new Sprite(assets.getEnemy());
        enemy.setPosition(CAMERA_WIDTH, PLATFORM_Y);
        stuff.getRobotPanel().getEnemies().add(enemy);
    }

    private void moveEnemies(float delta) {
        DelayedRemovalArray<Sprite> enemies = stuff.getRobotPanel().getEnemies();
        for (int i = 0; i < enemies.size; i++) {
            enemies.get(i).translateX(-ENEMY_SPEED * delta);
        }
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}