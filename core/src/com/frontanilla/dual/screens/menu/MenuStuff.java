package com.frontanilla.dual.screens.menu;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.frontanilla.dual.screens.shared.gui.ToggleSprite;
import com.frontanilla.dual.screens.shared.structure.Assets;

import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.frontanilla.dual.Constants.CREDITS_BUTTON_X;
import static com.frontanilla.dual.Constants.CREDITS_BUTTON_Y;
import static com.frontanilla.dual.Constants.HALF_CLEAR;
import static com.frontanilla.dual.Constants.PLAY_BUTTON_X;
import static com.frontanilla.dual.Constants.PLAY_BUTTON_Y;
import static com.frontanilla.dual.Constants.TUTORIAL_BUTTON_X;
import static com.frontanilla.dual.Constants.TUTORIAL_BUTTON_Y;

public class MenuStuff {

    private Assets assets;
    // Stuff
    private ToggleSprite playButton, tutorialButton, creditsButton;
    private Sprite menuGround;
    private Sprite tutorial, credits;

    public void initializeStuff() {
        playButton = new ToggleSprite(assets.getPlayButton(), assets.getPlayButton(), WHITE, HALF_CLEAR);
        playButton.setPosition(PLAY_BUTTON_X, PLAY_BUTTON_Y);
        tutorialButton = new ToggleSprite(assets.getTutorialButton(), assets.getTutorialButton(), WHITE, HALF_CLEAR);
        tutorialButton.setPosition(TUTORIAL_BUTTON_X, TUTORIAL_BUTTON_Y);
        creditsButton = new ToggleSprite(assets.getCreditsButton(), assets.getCreditsButton(), WHITE, HALF_CLEAR);
        creditsButton.setPosition(CREDITS_BUTTON_X, CREDITS_BUTTON_Y);

        menuGround = new Sprite(assets.getMenuGround());

        tutorial = new Sprite(assets.getTutorial());
        credits = new Sprite(assets.getCredits());
    }

    public ToggleSprite getPlayButton() {
        return playButton;
    }

    public ToggleSprite getTutorialButton() {
        return tutorialButton;
    }

    public ToggleSprite getCreditsButton() {
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

    public void setAssets(Assets assets) {
        this.assets = assets;
    }
}