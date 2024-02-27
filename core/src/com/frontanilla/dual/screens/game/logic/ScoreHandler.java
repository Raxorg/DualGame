package com.frontanilla.dual.screens.game.logic;

import com.frontanilla.dual.screens.game.stuff.GameStuff;

public class ScoreHandler {

    private GameStuff stuff;
    // Logic
    private float time;

    public void update(float delta) {
        time += delta;
        if (time >= 0.05f) {
            addScore(1);
            time = 0f;
        }
    }

    public void addScore(int additionalScore) {
        int score = Integer.parseInt(stuff.getScore().getText());
        score += additionalScore;
        stuff.getScore().setText(score + "");
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}