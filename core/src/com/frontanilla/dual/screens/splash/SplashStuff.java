package com.frontanilla.dual.screens.splash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.frontanilla.dual.screens.shared.gui.Text;

import static com.frontanilla.dual.Constants.LOGO_X;
import static com.frontanilla.dual.Constants.LOGO_Y;
import static com.frontanilla.dual.Constants.SPLASH_TEXT_SCALE;
import static com.frontanilla.dual.Constants.SPLASH_TEXT_X;
import static com.frontanilla.dual.Constants.SPLASH_TEXT_Y;

public class SplashStuff {

    private Sprite background, logo;
    private Text splashText;

    public void initializeStuff() {
        Texture backgroundTexture = new Texture(Gdx.files.internal("images/splashBackground.png"));
        background = new Sprite(backgroundTexture);
        Texture logoTexture = new Texture(Gdx.files.internal("images/logo.png"));
        logo = new Sprite(logoTexture);
        logo.setPosition(LOGO_X, LOGO_Y);
        BitmapFont pixelFont = new BitmapFont(Gdx.files.internal("fonts/pixelFont.fnt"));
        pixelFont.getData().setScale(SPLASH_TEXT_SCALE);
        splashText = new Text(pixelFont);
        splashText.setPosition(SPLASH_TEXT_X, SPLASH_TEXT_Y);
        splashText.setText("Groxar Studios");
    }

    public void dispose() {
        background.getTexture().dispose();
        logo.getTexture().dispose();
        splashText.dispose();
    }

    public Sprite getBackground() {
        return background;
    }

    public Sprite getLogo() {
        return logo;
    }

    public Text getSplashText() {
        return splashText;
    }
}