package com.frontanilla.dual.screens.game.stuff;

import com.frontanilla.dual.screens.shared.structure.Assets;

public class GameStuff {

    private Assets assets;
    // Stuff
    private SnakePanel snakePanel;
    private PlatformerPanel platformerPanel;

    public void initializeStuff() {
        snakePanel = new SnakePanel(assets);
        platformerPanel = new PlatformerPanel(assets);
    }

    public SnakePanel getSnakePanel() {
        return snakePanel;
    }

    public PlatformerPanel getPlatformerPanel() {
        return platformerPanel;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }
}