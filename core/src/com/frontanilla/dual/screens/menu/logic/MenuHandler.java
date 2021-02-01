package com.frontanilla.dual.screens.menu.logic;

import com.frontanilla.dual.screens.game.GameInitializer;
import com.frontanilla.dual.screens.menu.MenuStuff;
import com.frontanilla.dual.screens.shared.structure.Assets;
import com.frontanilla.dual.screens.shared.structure.Input;
import com.frontanilla.dual.screens.shared.structure.Screen;

import static com.frontanilla.dual.Constants.CAMERA_HEIGHT;
import static com.frontanilla.dual.Constants.CAMERA_WIDTH;

public class MenuHandler {

    private Assets assets;
    private Input input;
    private Screen screen;
    private MenuStuff stuff;
    // Logic
    private boolean screenLocked;

    public void configureMenu() {
        stuff.getTutorial().setPosition(-CAMERA_WIDTH, -CAMERA_HEIGHT);
        stuff.getCredits().setPosition(-CAMERA_WIDTH, -CAMERA_HEIGHT);
        screenLocked = false;
    }

    public void deselectButtons() {
        stuff.getPlayButton().useSprite1();
        stuff.getTutorialButton().useSprite1();
        stuff.getCreditsButton().useSprite1();
    }

    public void touchUp() {
        if (screenLocked) {
            hideOverlays();
        }
    }

    private void hideOverlays() {
        stuff.getTutorial().setPosition(-CAMERA_WIDTH, -CAMERA_HEIGHT);
        stuff.getCredits().setPosition(-CAMERA_WIDTH, -CAMERA_HEIGHT);
        screenLocked = false;
    }

    public void playButtonPressed() {
        if (screenLocked) {
            hideOverlays();
            return;
        }
        new GameInitializer().initialize(assets, input, screen);
    }

    public void tutorialButtonPressed() {
        if (screenLocked) {
            hideOverlays();
            return;
        }
        stuff.getTutorial().setPosition(0, 0);
        screenLocked = true;
    }

    public void creditsButtonPressed() {
        if (screenLocked) {
            hideOverlays();
            return;
        }
        stuff.getCredits().setPosition(0, 0);
        screenLocked = true;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setStuff(MenuStuff stuff) {
        this.stuff = stuff;
    }
}