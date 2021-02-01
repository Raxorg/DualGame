package com.frontanilla.dual.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.frontanilla.dual.DualGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1200;
		config.height = 800;
		config.addIcon("images/icon32.png", Files.FileType.Internal);
		config.addIcon("images/icon64.png", Files.FileType.Internal);
		config.addIcon("images/icon.png", Files.FileType.Internal);
		config.title = "Snakebot - Dual Game";
		config.forceExit = false;
		new LwjglApplication(new DualGame(), config);
	}
}
