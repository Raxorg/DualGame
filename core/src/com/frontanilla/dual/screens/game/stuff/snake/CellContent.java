package com.frontanilla.dual.screens.game.stuff.snake;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frontanilla.dual.enums.ContentType;

public abstract class CellContent {

    private Cell cell;
    private final Sprite sprite;
    private final ContentType contentType;

    public CellContent(Cell startingCell, Sprite contentSprite, ContentType contentType) {
        cell = startingCell;
        cell.setCellContent(this);
        sprite = new Sprite(contentSprite);
        sprite.setPosition(cell.getX(), cell.getY());
        this.contentType = contentType;
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell newCell) {
        cell.setCellContent(null);
        cell = newCell;
        cell.setCellContent(this);
        sprite.setPosition(cell.getX(), cell.getY());
    }

    public ContentType getContentType() {
        return contentType;
    }
}