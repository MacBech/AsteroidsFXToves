package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CollisionHandlerTest {


    @Test
    void collision() {
        CollisionHandler collisionHandler = new CollisionHandler();
        Entity entity1 = new Entity();
        Entity entity2 = new Entity();

        entity1.setRadius(5);
        entity2.setRadius(5);

        // Both entities will have their x and y coordinates set to 0.0

        boolean collision = collisionHandler.collision(entity1, entity2);

        assertTrue(collision);
    }
}