package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import java.util.Random;

/**
 * @author kkost
 */

public class EnemyControlSystem implements IEntityProcessingService{

    private Entity enemy;
    @Override
    public void process(GameData gameData, World world) {


        for (Entity enemy : world.getEntities(Enemy.class)) {
            PositionPart positionPart = enemy.getPart(PositionPart.class);
            MovingPart movingPart = enemy.getPart(MovingPart.class);
            LifePart lifePart = enemy.getPart(LifePart.class);

            Random rand = new Random();

            float rng = rand.nextFloat();

            if (rng > 0.1f && rng < 0.9f) {
                movingPart.setUp(true);
            }

            if (rng < 0.2f) {
                movingPart.setLeft(true);
            }

            if (rng > 0.8f) {
                movingPart.setRight(true);
            }

            movingPart.process(gameData, enemy);
            positionPart.process(gameData, enemy);
            lifePart.process(gameData, enemy);

            updateShape(enemy);

            movingPart.setRight(false);
            movingPart.setLeft(false);
            movingPart.setUp(false);
        }
    }

    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * 5);
        shapey[0] = (float) (y + Math.sin(radians) * 5);

        shapex[1] = (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * 5);
        shapey[1] = (float) (y + Math.sin(radians - 4 * 3.1145f / 5) * 5);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * 2);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * 2);

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * 5);
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * 5);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }
}
