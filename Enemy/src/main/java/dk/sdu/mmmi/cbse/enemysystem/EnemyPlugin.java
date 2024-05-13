package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class EnemyPlugin implements IGamePluginService {

    private Entity enemy;

    @Override
    public void start(GameData gameData, World world) {

        enemy = createEnemy(gameData);
        world.addEntity(enemy);
    }

    public Entity createEnemy(GameData gameData) {

        Entity enemyShip = new Entity();

        enemyShip.setPolygonCoordinates(-10, 0, 0, 20, 10, 0, 0, -20);
        enemyShip.setColor("RED");
        enemyShip.setX(200);
        enemyShip.setY(200);


        return enemyShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(enemy);
    }

}
