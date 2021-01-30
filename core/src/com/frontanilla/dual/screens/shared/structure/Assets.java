package com.frontanilla.dual.screens.shared.structure;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Assets {

    private final AssetManager assetManager;
    // Audio
    private Sound motor;
    // Fonts
    // Sprites
    private Sprite pixel;
    private Sprite groundTile;
    private Sprite bush;
    private Sprite robot;

    public Assets() {
        assetManager = new AssetManager();
    }

    public void queueAssetLoading() {
        // Audio
        assetManager.load("audio/motor1.wav", Sound.class);
        // Sprites
        assetManager.load("images/pixel.png", Texture.class);
        assetManager.load("images/groundTile.png", Texture.class);
        assetManager.load("images/bush.png", Texture.class);
        assetManager.load("images/robot.png", Texture.class);
    }

    public boolean loadAssets() {
        return assetManager.update();
    }

    public void initializeAssets() {
        motor = assetManager.get("audio/motor1.wav", Sound.class);
        // Sprites
        pixel = new Sprite(assetManager.get("images/pixel.png", Texture.class));
        groundTile = new Sprite(assetManager.get("images/groundTile.png", Texture.class));
        bush = new Sprite(assetManager.get("images/bush.png", Texture.class));
        bush.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        robot = new Sprite(assetManager.get("images/robot.png", Texture.class));
        robot.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    // Audio
    public Sound getMotor() {
        return motor;
    }

    // Sprites
    public Sprite getPixel() {
        return pixel;
    }

    public Sprite getGroundTile() {
        return groundTile;
    }

    public Sprite getBush() {
        return bush;
    }

    public Sprite getRobot() {
        return robot;
    }
}