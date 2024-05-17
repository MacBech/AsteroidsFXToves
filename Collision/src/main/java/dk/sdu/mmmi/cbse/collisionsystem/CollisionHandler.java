package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.asteroid.IAsteroidSplit;
import dk.sdu.mmmi.cbse.asteroidsystem.AsteroidSplitter;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CollisionHandler implements IPostEntityProcessingService {

    private IAsteroidSplit asteroidSplit = new AsteroidSplitter();


    @Override
    public void process(GameData gameData, World world) {

        int amount = 0;

        // Double loop, to check all entities against each other
        for (Entity entity1 : world.getEntities()) {
            for (Entity entity2 : world.getEntities()) {

                if (entity1.getID().equals(entity2.getID())) {
                    continue;
                    // Doesn't have to check for collision on itself
                }


                // Main collision system
                if (this.collision(entity1, entity2)) {

                    // Asteroids do not collide with each other
                    if (entity1 instanceof Asteroid && entity2 instanceof Asteroid) {
                        continue;
                    }

                    // Finds asteroids with high HP for split on collision
                    if (entity2 instanceof Asteroid && ((Asteroid) entity2).getHP() > 1) {
                        asteroidSplit.createAsteroidSplit(world, entity2);
                    } else if (entity1 instanceof Asteroid && ((Asteroid) entity1).getHP() > 1) {
                        asteroidSplit.createAsteroidSplit(world, entity2);
                    }

                    // Removes colliding entities
                    world.removeEntity(entity2);
                    world.removeEntity(entity1);


                    // Microservice
                    amount++;
                    System.out.println(amount);

                    String url = String.format("http://localhost:8080/update?amount=%d", amount);
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(url))
                            .build();
                    try {
//                            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//                            System.out.println(response.body());
                        client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
                    } catch (Exception e) {
                        System.out.println("Couldn't update score");

                    }
                }
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
