import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    requires CommonAsteroid;
    requires Asteroid;
    requires java.net.http;
    provides IPostEntityProcessingService with dk.sdu.mmmi.cbse.collisionsystem.CollisionHandler;
}