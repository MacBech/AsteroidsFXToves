package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class AsteroidPlugin implements IGamePluginService {


    @Override
    public void start(GameData gameData, World world) {

        // Creating asteroid entities
        Entity asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }

    @Override
    public void stop(GameData gameData, World world) {

        // Removing asteroid entities
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            world.removeEntity(asteroid);
        }

    }

    public Entity createAsteroid(GameData gameData) {

        System.out.println("create Asteroid!");

        Entity asteroid = new Asteroid();
//        asteroid.setColor("GREY");
        asteroid.setPolygonCoordinates(0,0,12,0,12,6,8,12,0,8);

        asteroid.setRadius(100);
        asteroid.setRotation(180);
        asteroid.setX(500);
        asteroid.setY(500);


        return asteroid;
    }

}
