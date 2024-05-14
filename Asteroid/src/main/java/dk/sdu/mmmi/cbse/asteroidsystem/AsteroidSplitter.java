package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.asteroid.IAsteroidSplit;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.World;

import java.util.Random;

public class AsteroidSplitter implements IAsteroidSplit {


    @Override
    public void createAsteroidSplit(World world, Entity entity) {

        // Removing original asteroid
        System.out.println("Asteroid splitting");

        Entity asteroid1 = new Asteroid();
        Entity asteroid2 = new Asteroid();

        double scale = 0.6;

        asteroid1.setPolygonCoordinates(0 * scale, 6 * scale,
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
        asteroid2.setPolygonCoordinates(asteroid1.getPolygonCoordinates());

        asteroid1.setRotation(entity.getRotation()+new Random().nextInt(120,180));
        asteroid2.setRotation(entity.getRotation()-new Random().nextInt(30,90));
        System.out.println(asteroid1.getRotation());
        System.out.println(asteroid2.getRotation());

        asteroid1.setX(entity.getX()+Math.cos(Math.toRadians(entity.getRotation())));
        asteroid1.setY(entity.getY()+Math.sin(Math.toRadians(entity.getRotation())));

        asteroid2.setX(entity.getX()+Math.cos(Math.toRadians(entity.getRotation()))*3);
        asteroid2.setY(entity.getY()+Math.sin(Math.toRadians(entity.getRotation()))*3);

        asteroid1.setColor("GREY");
        asteroid2.setColor("GREY");

        world.addEntity(asteroid1);
        world.addEntity(asteroid2);

        world.removeEntity(entity);

    }


}
