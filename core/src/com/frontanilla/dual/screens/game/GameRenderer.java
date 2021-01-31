package com.frontanilla.dual.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frontanilla.dual.screens.game.stuff.GameStuff;
import com.frontanilla.dual.screens.shared.structure.Renderer;
import com.frontanilla.dual.screens.shared.structure.Screen;

import static com.frontanilla.dual.Constants.TOON_SKY;

public class GameRenderer extends Renderer {

    private Screen screen;
    private com.frontanilla.dual.screens.game.stuff.GameStuff stuff;
    // Renderer
    private final SpriteBatch spriteBatch;

    public GameRenderer() {
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void render() {
        // Clear previous frame
        Gdx.gl.glClearColor(TOON_SKY.r, TOON_SKY.g, TOON_SKY.b, TOON_SKY.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Use the camera
        spriteBatch.setProjectionMatrix(screen.getCamera().combined);
        // Draw stuff
        spriteBatch.begin();
        stuff.getSnakePanel().draw(spriteBatch);
        stuff.getRobotPanel().draw(spriteBatch);
        spriteBatch.end();
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}