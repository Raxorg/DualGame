package com.frontanilla.dual.screens.game.logic;

import com.frontanilla.dual.screens.game.stuff.GameStuff;
import com.frontanilla.dual.screens.shared.structure.Assets;
import com.frontanilla.dual.screens.shared.structure.Input;
import com.frontanilla.dual.screens.shared.structure.Logic;
import com.frontanilla.dual.screens.shared.structure.Screen;

public class GameLogic extends Logic {

    private final GameInputHandler gameInputHandler;
    private final NatureHandler natureHandler;
    private final RobotHandler robotHandler;

    public GameLogic() {
        gameInputHandler = new GameInputHandler();
        natureHandler = new NatureHandler();
        robotHandler = new RobotHandler();
    }

    public void initialLogic() {
        gameInputHandler.configureInput();
        natureHandler.configureNature();
        robotHandler.configureRobot();
    }

    @Override
    public void update(float delta) {
        natureHandler.update(delta);
        robotHandler.update(delta);
    }

    public void setAssets(Assets assets) {
        natureHandler.setAssets(assets);
        robotHandler.setAssets(assets);
    }

    public void setInput(Input input) {
        gameInputHandler.setInput(input);
    }

    public void setScreen(Screen screen) {
        gameInputHandler.setScreen(screen);
    }

    public void setStuff(GameStuff stuff) {
        natureHandler.setStuff(stuff);
        robotHandler.setStuff(stuff);
    }
}