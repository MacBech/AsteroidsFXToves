package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Random;

public class AsteroidControlSystem implements IEntityProcessingService {


    @Override
    public void process(GameData gameData, World world) {

        for (Entity asteroid : world.getEntities(Asteroid.class)) {


            // Movement
            double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
            double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));

            asteroid.setX(asteroid.getX() + changeX * 0.6);
            asteroid.setY(asteroid.getY() + changeY * 0.6);

            // Screen boundary check
            if (asteroid.getX() <= 0) {
                asteroid.setRotation(asteroid.getRotation() + 180 + new Random().nextInt(60));
            }

            if (asteroid.getX() >= gameData.getDisplayWidth()) {
                asteroid.setRotation(asteroid.getRotation() - 180 + new Random().nextInt(60));
            }

            if (asteroid.getY() <= 0) {
                asteroid.setRotation(asteroid.getRotation() + 180 + new Random().nextInt(60));
            }

            if (asteroid.getY() > gameData.getDisplayHeight()) {
                asteroid.setRotation(asteroid.getRotation() - 180 + new Random().nextInt(60));
            }


            // Asteroid spawner - optional




        }

    }


}
