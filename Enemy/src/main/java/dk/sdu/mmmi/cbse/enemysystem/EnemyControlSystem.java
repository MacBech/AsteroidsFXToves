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

    @Override
    public void process(GameData gameData, World world) {

        // Movement


        // Border check


        for (Entity enemy : world.getEntities(Entity.class)) {


            // Shooting

            if (Math.random() > 0.96) {

                for (BulletSPI bulletSPI : getBulletSPIs()) {
                    Entity bullet = bulletSPI.createBullet(enemy, gameData);
                    bullet.setColor("RED");
                    world.addEntity(bullet);

                }
            }


        }


    }


    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }


}
