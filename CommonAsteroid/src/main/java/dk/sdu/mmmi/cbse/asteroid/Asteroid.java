package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;

public class Asteroid extends Entity {

    private int health = 2;


    public int getHP() {
        return health;
    }

    public void setHP(int asteroidHP) {
        this.health = asteroidHP;
    }
}
