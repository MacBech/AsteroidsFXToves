package dk.sdu.mmmi.cbse.playersystem;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class Player implements IGamePluginService {
    @Override
    public void start(GameData gameData, World world) {
        System.out.println("\u001B[36m" +"\u001B[40m"+ "Split package says hi!" + "\u001B[0m");
    }

    @Override
    public void stop(GameData gameData, World world) {

    }
}
