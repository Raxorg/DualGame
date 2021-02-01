package com.frontanilla.dual;

import com.badlogic.gdx.graphics.Color;

public class Constants {

    // Colors
    public static final Color TOON_SKY = new Color(0xb8ffffff);
    public static final Color DARK_GRASS = new Color(0x71aa34ff);
    public static final Color LIGHT_GRASS = new Color(0xb6d53cff);
    public static final Color DARK_DIRT = new Color(0xeea160ff);
    public static final Color NICE_BLUE = new Color(0x0064ffff);
    public static final Color HALF_CLEAR = new Color(1, 1, 1, 0.5f);
    // Camera
    public static final int CAMERA_HEIGHT = 800;
    public static final int CAMERA_WIDTH = 1200;
    //--------
    // Splash
    //--------
    private static final int LOGO_WIDTH = 512;
    private static final int LOGO_HEIGHT = 459;
    public static final int LOGO_X = CAMERA_WIDTH / 2 - LOGO_WIDTH / 2;
    public static final int LOGO_Y = CAMERA_HEIGHT / 2 - LOGO_HEIGHT / 2;
    public static final int SPLASH_TEXT_SCALE = 4;
    public static final int SPLASH_TEXT_HEIGHT = 9 * SPLASH_TEXT_SCALE;
    public static final int SPLASH_TEXT_X = CAMERA_WIDTH / 2;
    public static final int SPLASH_TEXT_Y = LOGO_Y - SPLASH_TEXT_HEIGHT;
    public static final float SPLASH_MINIMUM_DURATION = 4f;
    //------
    // Menu
    //------
    public static final int BUTTON_SIZE = 200;
    public static final int PLAY_BUTTON_X = CAMERA_WIDTH / 2 - BUTTON_SIZE / 2;
    public static final int PLAY_BUTTON_Y = (CAMERA_HEIGHT / 4) * 3 - BUTTON_SIZE / 2;
    public static final int TUTORIAL_BUTTON_X = CAMERA_WIDTH / 3 - BUTTON_SIZE / 2;
    public static final int TUTORIAL_BUTTON_Y = CAMERA_HEIGHT / 4 - BUTTON_SIZE / 2;
    public static final int CREDITS_BUTTON_X = (CAMERA_WIDTH / 3) * 2 - BUTTON_SIZE / 2;
    public static final int CREDITS_BUTTON_Y = CAMERA_HEIGHT / 4 - BUTTON_SIZE / 2;
    //--------
    // Shared
    //--------
    // Frames
    public static final int FRAME_THICKNESS = 10;
    public static final int FRAME_WIDTH = CAMERA_WIDTH;
    public static final int FRAME_HEIGHT = CAMERA_HEIGHT / 2 + FRAME_THICKNESS / 2;
    public static final int INNER_FRAME_HEIGHT = FRAME_HEIGHT - FRAME_THICKNESS * 2;

    public static final int FULLNESS_UNIT = 32;
    public static final int FULL_BAR = FULLNESS_UNIT * 6;
    //-------------
    // Snake panel
    //-------------
    // Grid
    public static final int CELL_SIZE = 30;
    public static final int GRID_COLUMNS = 24;
    public static final int GRID_ROWS = 10;
    public static final int CELL_SPACING = 5;
    public static final int GRID_WIDTH = CELL_SPACING * (GRID_COLUMNS + 1) + CELL_SIZE * GRID_COLUMNS;
    public static final int GRID_HEIGHT = CELL_SPACING * (GRID_ROWS + 1) + CELL_SIZE * GRID_ROWS;
    public static final int GRID_X = CAMERA_WIDTH / 2 - GRID_WIDTH / 2;
    public static final int GRID_Y = FRAME_HEIGHT + INNER_FRAME_HEIGHT / 2 - GRID_HEIGHT / 2;
    // Food
    public static final int FOOD_SPAWN_INTERVAL = 10;
    public static final int APPLES_PER_SPAWN = 6;
    public static final int SCREWS_PER_SPAWN = 4;
    public static final int BAD_APPLES_PER_SPAWN = 12;
    public static final int APPLE_HEALING = FULLNESS_UNIT / 2;
    public static final int BAD_APPLE_DAMAGE = FULLNESS_UNIT / 2;
    public static final int CANNIBALISM_DAMAGE = FULLNESS_UNIT / 4;
    // Snake
    public static final int STARTING_COLUMN = 0;
    public static final int STARTING_ROW = GRID_ROWS / 2;
    // Nature
    public static final int GROUND_TILE_WIDTH = 200;
    public static final int GROUND_TILE_HEIGHT = 77;
    public static final int GROUND_TILES = CAMERA_WIDTH / GROUND_TILE_WIDTH + 1;
    public static final float MIN_NATURE_SPAWN_INTERVAL = 1f;
    public static final float MAX_NATURE_SPAWN_INTERVAL = 3f;
    public static final int NATURE_SPEED = 200;
    //-------------
    // Robot panel
    //-------------
    public static final int PLATFORM_Y = FRAME_THICKNESS + GROUND_TILE_HEIGHT;
    public static final int FRAME_MARGIN = 10;
    // Robot bars
    public static final int ROBOT_BAR_ICON_SIZE = 40;
    public static final int ROBOT_BAR_WIDTH = 200;
    public static final int ROBOT_BAR_HEIGHT = 40;
    public static final int ROBOT_BAR_MARGIN = 4;
    public static final int ROBOT_BAR_BAR_OFFSET = ROBOT_BAR_ICON_SIZE + 10;
    public static final int ROBOT_BAR_SPACING = ROBOT_BAR_BAR_OFFSET + ROBOT_BAR_WIDTH + 50;
    public static final int ROBOT_BAR_Y = FRAME_HEIGHT - FRAME_THICKNESS - FRAME_MARGIN - ROBOT_BAR_HEIGHT;
    public static final int HEALTH_BAR_X = FRAME_THICKNESS + FRAME_MARGIN;
    public static final int AMMO_BAR_X = HEALTH_BAR_X + ROBOT_BAR_SPACING;
    // Robot
    public static final int ROBOT_X = 100;
    public static final int ROBOT_Y = PLATFORM_Y;
    public static final int ROBOT_WIDTH = 170;
    public static final int ROBOT_WEAPON_ALTITUDE = 87;
    // Rocket
    public static final int ROCKET_HEIGHT = 39;
    public static final int ROCKET_X = ROBOT_X + ROBOT_WIDTH - 20;
    public static final int ROCKET_Y = ROBOT_Y + ROBOT_WEAPON_ALTITUDE - ROCKET_HEIGHT / 2;
    public static final int ROCKET_SPEED = 600;
    // Enemies
    public static final int ENEMY_SPEED = 400;
    public static final int ENEMY_DAMAGE = FULLNESS_UNIT * 2;
}