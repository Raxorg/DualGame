package com.frontanilla.dual.screens.game.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.dual.screens.game.stuff.GameStuff;
import com.frontanilla.dual.screens.shared.structure.Assets;

import static com.badlogic.gdx.graphics.Color.FOREST;
import static com.badlogic.gdx.graphics.Color.ORANGE;
import static com.frontanilla.dual.Constants.CAMERA_WIDTH;
import static com.frontanilla.dual.Constants.FRAME_THICKNESS;
import static com.frontanilla.dual.Constants.GROUND_TILES;
import static com.frontanilla.dual.Constants.GROUND_TILE_WIDTH;
import static com.frontanilla.dual.Constants.MAX_NATURE_SPAWN_INTERVAL;
import static com.frontanilla.dual.Constants.MIN_NATURE_SPAWN_INTERVAL;
import static com.frontanilla.dual.Constants.NATURE_SPEED;
import static com.frontanilla.dual.Constants.PLATFORM_Y;

public class NatureHandler {

    private Assets assets;
    private GameStuff stuff;
    // Logic
    private float time, spawnInterval;

    public void configureNature() {
        time = 0f;
        spawnInterval = MathUtils.random(MIN_NATURE_SPAWN_INTERVAL, MAX_NATURE_SPAWN_INTERVAL);
        generateGround();

        Sprite bush = new Sprite(assets.getBush());
        bush.setPosition(CAMERA_WIDTH / 2f, PLATFORM_Y);
        stuff.getRobotPanel().getBackgroundNature().add(bush);
    }

    private void generateGround() {
        DelayedRemovalArray<Sprite> groundTiles = stuff.getRobotPanel().getGroundTiles();
        for (int i = 0; i < GROUND_TILES; i++) {
            Sprite groundTile = new Sprite(assets.getGroundTile());
            groundTile.setPosition(FRAME_THICKNESS + GROUND_TILE_WIDTH * i, FRAME_THICKNESS);
            groundTiles.add(groundTile);
        }
    }

    public void update(float delta) {
        time += delta;
        checkSpawnInterval();
        moveNature(delta);
        checkNatureVisibility();
    }

    private void checkSpawnInterval() {
        if (time >= spawnInterval) {
            spawnRandomNature();
            time = 0f;
            spawnInterval = MathUtils.random(MIN_NATURE_SPAWN_INTERVAL, MAX_NATURE_SPAWN_INTERVAL);
        }
    }

    private void spawnRandomNature() {
        Sprite bush = new Sprite(assets.getBush());
        bush.setPosition(CAMERA_WIDTH, PLATFORM_Y);
        bush.setOrigin(0f, 0f);
        bush.setScale(MathUtils.random(0.25f, 1f));
        bush.setColor(FOREST.cpy().lerp(ORANGE, MathUtils.random(0f, 1f)));
        bush.flip(MathUtils.randomBoolean(), false);

        boolean background = MathUtils.randomBoolean();
        if (background) {
            stuff.getRobotPanel().getBackgroundNature().add(bush);
        } else {
            stuff.getRobotPanel().getForegroundNature().add(bush);
        }
    }

    private void moveNature(float delta) {
        DelayedRemovalArray<Sprite> natureArray = stuff.getRobotPanel().getGroundTiles();
        for (int i = 0; i < natureArray.size; i++) {
            natureArray.get(i).translateX(-NATURE_SPEED * delta);
        }
        natureArray = stuff.getRobotPanel().getBackgroundNature();
        for (int i = 0; i < natureArray.size; i++) {
            natureArray.get(i).translateX(-NATURE_SPEED * delta);
        }
        natureArray = stuff.getRobotPanel().getForegroundNature();
        for (int i = 0; i < natureArray.size; i++) {
            natureArray.get(i).translateX(-NATURE_SPEED * delta);
        }
    }

    private void checkNatureVisibility() {
        DelayedRemovalArray<Sprite> natureArray = stuff.getRobotPanel().getGroundTiles();
        natureArray.begin();
        for (int i = 0; i < natureArray.size; i++) {
            if (natureArray.get(i).getX() < -natureArray.get(i).getWidth()) {
                natureArray.removeValue(natureArray.get(i), true);
                Sprite groundTile = new Sprite(assets.getGroundTile());
                Sprite lastTile = natureArray.get(natureArray.size - 1);
                groundTile.setPosition(lastTile.getX() + GROUND_TILE_WIDTH, FRAME_THICKNESS);
                natureArray.add(groundTile);
            }
        }
        natureArray.end();
        natureArray = stuff.getRobotPanel().getBackgroundNature();
        natureArray.begin();
        for (int i = 0; i < natureArray.size; i++) {
            if (natureArray.get(i).getX() < -natureArray.get(i).getWidth()) {
                natureArray.removeValue(natureArray.get(i), true);
            }
        }
        natureArray.end();
        natureArray = stuff.getRobotPanel().getForegroundNature();
        natureArray.begin();
        for (int i = 0; i < natureArray.size; i++) {
            if (natureArray.get(i).getX() < -natureArray.get(i).getWidth()) {
                natureArray.removeValue(natureArray.get(i), true);
            }
        }
        natureArray.end();
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}