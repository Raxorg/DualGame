package com.frontanilla.dual.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;

public class RenderUtils {

    // Helper (To avoid instancing each frame)
    private final static GlyphLayout glyphLayout = new GlyphLayout();

    public static void circle(ShapeRenderer shapeRenderer, Rectangle bounds) {
        float radius = Math.min(bounds.width, bounds.height) / 2f;
        shapeRenderer.circle(
                bounds.x + bounds.width / 2f,
                bounds.y + bounds.height / 2f,
                radius);
    }

    public static void rectangle(ShapeRenderer shapeRenderer, Rectangle bounds) {
        shapeRenderer.rect(
                bounds.x,
                bounds.y,
                bounds.width,
                bounds.height);
    }

    public static void drawCentered(BitmapFont font, SpriteBatch spriteBatch, String text, Rectangle bounds) {
        glyphLayout.setText(font, text, Color.BLACK, bounds.width, Align.center, true);
        font.draw(
                spriteBatch,
                text,
                bounds.x,
                bounds.y + bounds.height / 2f + glyphLayout.height / 2f,
                bounds.width,
                Align.center,
                true);
    }
}