package com.frontanilla.dual.screens.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frontanilla.dual.screens.shared.structure.Renderer;
import com.frontanilla.dual.screens.shared.structure.Screen;

import static com.frontanilla.dual.Constants.TOON_SKY;

public class MenuRenderer extends Renderer {

    private Screen screen;
    private MenuStuff stuff;
    // Renderer
    private final SpriteBatch spriteBatch;

    public MenuRenderer() {
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
        stuff.getPlayButton().draw(spriteBatch);
        stuff.getTutorialButton().draw(spriteBatch);
        stuff.getCreditsButton().draw(spriteBatch);
        stuff.getMenuGround().draw(spriteBatch);
        stuff.getTutorial().draw(spriteBatch);
        stuff.getCredits().draw(spriteBatch);
        spriteBatch.end();
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setStuff(MenuStuff stuff) {
        this.stuff = stuff;
    }
}
