package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.asteroid.IAsteroidSplit;
import dk.sdu.mmmi.cbse.asteroidsystem.AsteroidSplitter;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

public class CollisionHandler implements IPostEntityProcessingService {

    private IAsteroidSplit asteroidSplit = new AsteroidSplitter();

    @Override
    public void process(GameData gameData, World world) {

        for (Entity entity1 : world.getEntities()) {
            for (Entity entity2 : world.getEntities()) {

                if (entity1.equals(entity2)) {
                    continue;
                }


                if (this.collision(entity1, entity2)) {

                    if (entity2 instanceof Asteroid) {
                        asteroidSplit.createAsteroidSplit(world, entity2);
                    } else {
                        world.removeEntity(entity2);
                    }


                    if (entity1 instanceof Asteroid) {
                        asteroidSplit.createAsteroidSplit(world, entity1);
                    } else {
                        world.removeEntity(entity1);
                    }


                }

                // TODO: Asteroid detection split


            }
        }

    }

    public boolean collision(Entity entity1, Entity entity2) {
        float distanceX = (float) entity1.getX() - (float) entity2.getX();
        float distanceY = (float) entity1.getY() - (float) entity2.getY();
        float distance = (float) Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        return distance < entity1.getRadius() + entity2.getRadius();


    }

}
