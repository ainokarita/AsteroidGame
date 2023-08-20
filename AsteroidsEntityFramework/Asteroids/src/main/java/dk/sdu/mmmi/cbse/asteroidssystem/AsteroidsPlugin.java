package dk.sdu.mmmi.cbse.asteroidssystem;


import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
/**
 * @author kkost
 */
public class AsteroidsPlugin implements IGamePluginService {
    // private Entity asteroids;

   // public AsteroidsPlugin() {}

    @Override
    public void start(GameData gameData, World world) {
       /**Adding asteroid entities to the world
        asteroids = createAsteroids(gameData);
        world.addEntity(asteroids);**/
        Entity asteroid = createAsteroids(gameData);
        world.addEntity(asteroid);
    }

    private Entity createAsteroids(GameData gameData) {
        Entity asteroids = new Asteroids();
        float radians = (float) Math.random() * 10 * 3.1415f;
        float speed = (float) Math.random() * 10f + 20f;

        asteroids.setRadius(35);
        asteroids.add(new MovingPart(0, speed, speed, 0));
        asteroids.add(new PositionPart(30, 30, radians));
        asteroids.add(new LifePart(3));

        return asteroids;
    }
    @Override
    public void stop(GameData gameData, World world) {
        /** removing asteroid entities from the field
        for (Entity asteroids : world.getEntities(Asteroids.class))
         **/
        for (Entity asteroids : world.getEntities(Asteroids.class)) {
            world.removeEntity(asteroids);
        }

    }
}
