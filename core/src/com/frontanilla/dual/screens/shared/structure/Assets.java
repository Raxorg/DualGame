package com.frontanilla.dual.screens.shared.structure;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Assets {

    private final AssetManager assetManager;
    // Audio
    private Music backgroundMusic;  // todo
    private Sound motor;
    // Fonts
    private BitmapFont pixelFont;
    // Sprites
    private Sprite pixel;
    private Sprite apple, screw, badApple;
    private Sprite snakeHead, snakeBody;
    private Sprite groundTile, bush;
    private Sprite barTopLayer, heart, rocket;
    private Sprite robot, firedRocket;

    public Assets() {
        assetManager = new AssetManager();
    }

    public void queueAssetLoading() {
        // Audio

        assetManager.load("audio/motor1.wav", Sound.class);
        // Fonts
        assetManager.load("fonts/pixelFont.fnt", BitmapFont.class);
        // Sprites
        assetManager.load("images/pixel.png", Texture.class);

        assetManager.load("images/apple.png", Texture.class);
        assetManager.load("images/screw.png", Texture.class);
        assetManager.load("images/badApple.png", Texture.class);

        assetManager.load("images/snakeHead.png", Texture.class);
        assetManager.load("images/snakeBody.png", Texture.class);

        assetManager.load("images/groundTile.png", Texture.class);
        assetManager.load("images/bush.png", Texture.class);

        assetManager.load("images/barTopLayer.png", Texture.class);
        assetManager.load("images/heart.png", Texture.class);
        assetManager.load("images/rocket.png", Texture.class);

        assetManager.load("images/robot.png", Texture.class);
        assetManager.load("images/firedRocket.png", Texture.class);
    }

    public boolean loadAssets() {
        return assetManager.update();
    }

    public void initializeAssets() {
        // Audio
        motor = assetManager.get("audio/motor1.wav", Sound.class);
        // Fonts
        pixelFont = assetManager.get("fonts/pixelFont.fnt", BitmapFont.class);
        // Sprites
        pixel = new Sprite(assetManager.get("images/pixel.png", Texture.class));

        apple = new Sprite(assetManager.get("images/apple.png", Texture.class));
        screw = new Sprite(assetManager.get("images/screw.png", Texture.class));
        badApple = new Sprite(assetManager.get("images/badApple.png", Texture.class));

        snakeHead = new Sprite(assetManager.get("images/snakeHead.png", Texture.class));
        snakeBody = new Sprite(assetManager.get("images/snakeBody.png", Texture.class));

        groundTile = new Sprite(assetManager.get("images/groundTile.png", Texture.class));
        bush = new Sprite(assetManager.get("images/bush.png", Texture.class));
        bush.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        barTopLayer = new Sprite(assetManager.get("images/barTopLayer.png", Texture.class));
        heart = new Sprite(assetManager.get("images/heart.png", Texture.class));
        rocket = new Sprite(assetManager.get("images/rocket.png", Texture.class));

        robot = new Sprite(assetManager.get("images/robot.png", Texture.class));
        robot.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        firedRocket = new Sprite(assetManager.get("images/firedRocket.png", Texture.class));
    }

    // Audio
    public Sound getMotor() {
        return motor;
    }

    // Fonts
    public BitmapFont getPixelFont() {
        return pixelFont;
    }

    // Sprites
    public Sprite getPixel() {
        return pixel;
    }

    public Sprite getApple() {
        return apple;
    }

    public Sprite getScrew() {
        return screw;
    }

    public Sprite getBadApple() {
        return badApple;
    }

    public Sprite getSnakeHead() {
        return snakeHead;
    }

    public Sprite getSnakeBody() {
        return snakeBody;
    }

    public Sprite getGroundTile() {
        return groundTile;
    }

    public Sprite getBush() {
        return bush;
    }

    public Sprite getBarTopLayer() {
        return barTopLayer;
    }

    public Sprite getHeart() {
        return heart;
    }

    public Sprite getRocket() {
        return rocket;
    }

    public Sprite getRobot() {
        return robot;
    }

    public Sprite getFiredRocket() {
        return firedRocket;
    }
}