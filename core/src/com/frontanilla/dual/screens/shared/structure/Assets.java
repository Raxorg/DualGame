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
    private Music backgroundMusic;
    private Sound motor, rocketLaunch;
    // Fonts
    private BitmapFont pixelFont;
    // Sprites
    private Sprite pixel;
    private Sprite playButton, tutorialButton, creditsButton, menuGround, tutorial, credits;
    private Sprite apple, screw, badApple;
    private Sprite snakeHead, snakeBody;
    private Sprite groundTile, bush;
    private Sprite barTopLayer, heart, rocket;
    private Sprite robot, enemy, firedRocket;

    public Assets() {
        assetManager = new AssetManager();
    }

    public void queueAssetLoading() {
        // Audio
        assetManager.load("audio/odyssey.mp3", Music.class);
        assetManager.load("audio/motor1.wav", Sound.class);
        assetManager.load("audio/rocketLaunch.mp3", Sound.class);
        // Fonts
        assetManager.load("fonts/pixelFont.fnt", BitmapFont.class);
        // Sprites
        assetManager.load("images/pixel.png", Texture.class);

        assetManager.load("images/playButton.png", Texture.class);
        assetManager.load("images/tutorialButton.png", Texture.class);
        assetManager.load("images/creditsButton.png", Texture.class);
        assetManager.load("images/menuGround.png", Texture.class);
        assetManager.load("images/tutorial.png", Texture.class);
        assetManager.load("images/credits.png", Texture.class);

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
        assetManager.load("images/enemy.png", Texture.class);
        assetManager.load("images/firedRocket.png", Texture.class);
    }

    public boolean loadAssets() {
        return assetManager.update();
    }

    public void initializeAssets() {
        // Audio
        backgroundMusic = assetManager.get("audio/odyssey.mp3", Music.class);
        motor = assetManager.get("audio/motor1.wav", Sound.class);
        rocketLaunch = assetManager.get("audio/rocketLaunch.mp3", Sound.class);
        // Fonts
        pixelFont = assetManager.get("fonts/pixelFont.fnt", BitmapFont.class);
        // Sprites
        pixel = new Sprite(assetManager.get("images/pixel.png", Texture.class));

        playButton = new Sprite(assetManager.get("images/playButton.png", Texture.class));
        tutorialButton = new Sprite(assetManager.get("images/tutorialButton.png", Texture.class));
        creditsButton = new Sprite(assetManager.get("images/creditsButton.png", Texture.class));
        menuGround = new Sprite(assetManager.get("images/menuGround.png", Texture.class));
        tutorial = new Sprite(assetManager.get("images/tutorial.png", Texture.class));
        credits = new Sprite(assetManager.get("images/credits.png", Texture.class));

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
        enemy = new Sprite(assetManager.get("images/enemy.png", Texture.class));
        enemy.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        firedRocket = new Sprite(assetManager.get("images/firedRocket.png", Texture.class));
    }

    // Audio
    public Music getBackgroundMusic() {
        return backgroundMusic;
    }

    public Sound getMotor() {
        return motor;
    }

    public Sound getRocketLaunch() {
        return rocketLaunch;
    }

    // Fonts
    public BitmapFont getPixelFont() {
        return pixelFont;
    }

    // Sprites
    public Sprite getPixel() {
        return pixel;
    }

    public Sprite getPlayButton() {
        return playButton;
    }

    public Sprite getTutorialButton() {
        return tutorialButton;
    }

    public Sprite getCreditsButton() {
        return creditsButton;
    }

    public Sprite getMenuGround() {
        return menuGround;
    }

    public Sprite getTutorial() {
        return tutorial;
    }

    public Sprite getCredits() {
        return credits;
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

    public Sprite getEnemy() {
        return enemy;
    }

    public Sprite getFiredRocket() {
        return firedRocket;
    }
}