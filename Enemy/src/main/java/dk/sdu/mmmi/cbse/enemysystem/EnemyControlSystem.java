package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.Random;
import java.util.ServiceLoader;

public class EnemyControlSystem implements IEntityProcessingService {

    private final Random random = new Random();
    private double speed = 0.6;

    @Override
    public void process(GameData gameData, World world) {


        for (Entity enemy : world.getEntities(Entity.class)) {


            // Movement
            if (Math.random() > 0.5) {
                enemy.setRotation(enemy.getRotation() + 4 + random.nextInt(2));
            } else {
                enemy.setRotation(enemy.getRotation() - 4 + random.nextInt(2));
            }

            // Keeps moving forward
            double changeX = speed * Math.cos(Math.toRadians(enemy.getRotation()));
            double changeY = speed * Math.sin(Math.toRadians(enemy.getRotation()));
            enemy.setX(enemy.getX() + changeX);
            enemy.setY(enemy.getY() + changeY);

            // Random shooting
            if (Math.random() > 0.98) {

                for (BulletSPI bulletSPI : getBulletSPIs()) {
                    Entity bullet = bulletSPI.createBullet(enemy, gameData);
                    bullet.setColor("RED");
                    world.addEntity(bullet);
                }
            }

            // Border check



        }

    }


    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }


}
