package com.frontanilla.dual;

import com.badlogic.gdx.graphics.Color;

public class Constants {

    // Colors
    public static final Color TOON_SKY = new Color(0xb8ffffff);
    public static final Color TOON_GRASS = new Color(0x8dc840ff);
    // Camera
    public static final int CAMERA_HEIGHT = 800;
    public static final int CAMERA_WIDTH = 1200;
    // Frames
    public static final int FRAME_THICKNESS = 10;
    public static final int FRAME_WIDTH = CAMERA_WIDTH;
    public static final int FRAME_HEIGHT = CAMERA_HEIGHT / 2 + FRAME_THICKNESS / 2;
    public static final int INNER_FRAME_HEIGHT = FRAME_HEIGHT - FRAME_THICKNESS * 2;
    // Grid
    public static final int CELL_SIZE = 50;
    public static final int GRID_COLUMNS = 12;
    public static final int GRID_ROWS = 6;
    public static final int CELL_SPACING = 5;
    public static final int GRID_WIDTH = CELL_SPACING * (GRID_COLUMNS + 1) + CELL_SIZE * GRID_COLUMNS;
    public static final int GRID_HEIGHT = CELL_SPACING * (GRID_ROWS + 1) + CELL_SIZE * GRID_ROWS;
    public static final int GRID_X = CAMERA_WIDTH / 2 - GRID_WIDTH / 2;
    public static final int GRID_Y = FRAME_HEIGHT + INNER_FRAME_HEIGHT / 2 - GRID_HEIGHT / 2;
    // Nature
    public static final int GROUND_TILE_WIDTH = 200;
    public static final int GROUND_TILE_HEIGHT = 77;
    public static final int GROUND_TILES = CAMERA_WIDTH / GROUND_TILE_WIDTH + 1;
    public static final float MIN_NATURE_SPAWN_INTERVAL = 2f;
    public static final float MAX_NATURE_SPAWN_INTERVAL = 5f;
    public static final int NATURE_SPEED = 200;
    // Shared
    public static final int PLATFORM_Y = FRAME_THICKNESS + GROUND_TILE_HEIGHT;
}