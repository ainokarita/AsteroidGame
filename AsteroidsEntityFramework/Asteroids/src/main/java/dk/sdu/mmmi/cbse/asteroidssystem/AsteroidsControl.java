package dk.sdu.mmmi.cbse.asteroidssystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IAsteroidsSplitter;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class AsteroidsControl implements IEntityProcessingService {

    private IAsteroidsSplitter asteroidsSplitter = new AsteroidsSplitter();
    @Override
    public void process(GameData gameData, World world) {
        for (Entity asteroids : world.getEntities(Asteroids.class)) {
            PositionPart positionPart = asteroids.getPart(PositionPart.class);
            MovingPart movingPart = asteroids.getPart(MovingPart.class);
            LifePart lifePart = asteroids.getPart(LifePart.class);

            int numPoints = 12;
            float speed = (float) Math.random() * 10f + 20f;
            if (lifePart.getLife() == 1) {
                numPoints = 8;
                speed = (float) Math.random() * 30f + 70f;
            } else if (lifePart.getLife() == 2) {
                numPoints = 10;
                speed = (float) Math.random() * 10f + 50f;
            }
            movingPart.setSpeed(speed);
            movingPart.setUp(true);

            movingPart.process(gameData, asteroids);
            positionPart.process(gameData, asteroids);

            // Split event
            if (lifePart.isHit()) {
                asteroidsSplitter.createSplitAsteroid(asteroids, world);
            }
            setShape(asteroids, numPoints);
        }
    }


    private void setShape(Entity entity, int numPoints) {
        PositionPart position = entity.getPart(PositionPart.class);
        float[] shapex = new float[numPoints];
        float[] shapey = new float[numPoints];
        float radians = position.getRadians();
        float x = position.getX();
        float y = position.getY();
        float radius = entity.getRadius();

        float angle = 0;
//shape of asteroid
        for (int i = 0; i < numPoints; i++) {
            shapex[i] = x + (float) Math.cos(angle + radians) * radius;
            shapey[i] = y + (float) Math.sin(angle + radians) * radius;
            angle += 25 * 3.1415f / numPoints;
        }

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }
}
