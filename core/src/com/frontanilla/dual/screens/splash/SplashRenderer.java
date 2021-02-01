package com.frontanilla.dual.screens.splash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frontanilla.dual.screens.shared.structure.Renderer;
import com.frontanilla.dual.screens.shared.structure.Screen;

import static com.frontanilla.dual.Constants.TOON_SKY;

public class SplashRenderer extends Renderer {

    private Screen screen;
    private SplashStuff stuff;
    // Renderer
    private final SpriteBatch spriteBatch;

    public SplashRenderer() {
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
        stuff.getBackground().draw(spriteBatch);
        stuff.getLogo().draw(spriteBatch);
        stuff.getSplashText().draw(spriteBatch);
        spriteBatch.end();
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setStuff(SplashStuff stuff) {
        this.stuff = stuff;
    }
}