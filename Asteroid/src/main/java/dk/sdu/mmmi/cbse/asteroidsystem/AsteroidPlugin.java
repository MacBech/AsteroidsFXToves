package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {


    @Override
    public void start(GameData gameData, World world) {

        // Creating asteroid entities
        int numberOfAsteroids = 12;

        for (int index = 0; index < numberOfAsteroids; index++) {
            Entity asteroid = createAsteroid(gameData);
            world.addEntity(asteroid);
        }

    }

    @Override
    public void stop(GameData gameData, World world) {

        // Removing asteroid entities
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            world.removeEntity(asteroid);
        }

    }

    public Entity createAsteroid(GameData gameData) {

        Entity asteroid = new Asteroid();
        asteroid.setColor("DARKGREY");

        // Sets random size of asteroids
        Random random = new Random();
        double scale = random.nextInt(1, 3);

        asteroid.setPolygonCoordinates(
                0 * scale, 6 * scale,
                4 * scale, 0 * scale,
                10 * scale, 2 * scale,
                16 * scale, 0 * scale,
                20 * scale, 6 * scale,
                24 * scale, 12 * scale,
                20 * scale, 18 * scale,
                14 * scale, 24 * scale,
                8 * scale, 20 * scale,
                4 * scale, 16 * scale
        );

        asteroid.setRadius((float) (12 * scale));


        // Setting random spawn location, bound by display
        int randomY = random.nextInt(gameData.getDisplayHeight() + 1);
        int randomX = random.nextInt(gameData.getDisplayWidth() + 1);
        asteroid.setX(randomX);
        asteroid.setY(randomY);

        // Random start rotation
        asteroid.setRotation(random.nextInt(360));

        return asteroid;
    }

}
