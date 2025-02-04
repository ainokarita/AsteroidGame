package dk.sdu.mmmi.cbse.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.TimerPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.BulletPart;
import dk.sdu.mmmi.cbse.common.services.BulletSPI;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
public class BulletControl implements IEntityProcessingService, BulletSPI {
    /**
     * Processes the entities
     *
     * @param gameData information about the game environment
     * @param world    contains the entities in the game
     */
    @Override
    public void process(GameData gameData, World world) {

        for (Entity entity : world.getEntities()) {
            BulletPart bulletPart = entity.getPart(BulletPart.class);
            PositionPart positionPart = entity.getPart(PositionPart.class);

            if (bulletPart != null) {
                if (bulletPart.canShoot()){
                    float x = positionPart.getX();
                    float y = positionPart.getY();
                    float rads = positionPart.getRadians();
                    spawnBullet(world, (float) (x + Math.cos(rads) * 15), (float) (y + Math.sin(rads) * 15 ), rads);
                    bulletPart.resetTimer();
                } else {bulletPart.timer();}
            }
        }

        for (Entity bullet : world.getEntities(Bullet.class)) {

            PositionPart positionPart = bullet.getPart(PositionPart.class);
            MovingPart movingPart = bullet.getPart(MovingPart.class);
            TimerPart timerPart = bullet.getPart(TimerPart.class);
            movingPart.setUp(true);

            timerPart.reduceExpiration(0.5f);
            if (timerPart.getExpiration() < 0) {
                world.removeEntity(bullet);
            }
            timerPart.process(gameData, bullet);
            movingPart.process(gameData, bullet);
            positionPart.process(gameData, bullet);

            updateShape(bullet);
        }
    }
    @Override
    public Entity createBullet(Entity shooter, GameData gameData) {
        PositionPart shooterPos = shooter.getPart(PositionPart.class);

        float x = shooterPos.getX();
        float y = shooterPos.getY();
        float radians = shooterPos.getRadians();
        float dt = gameData.getDelta();
        float speed = 350;

        Entity bullet = new Bullet();
        bullet.setRadius(2);

        float bx = (float) cos(radians) * shooter.getRadius() * bullet.getRadius();
        float by = (float) sin(radians) * shooter.getRadius() * bullet.getRadius();

        bullet.add(new PositionPart(bx + x, by + y, radians));
        bullet.add(new LifePart(1, 0));
        bullet.add(new MovingPart(0, 5000000, speed, 5));
        bullet.add(new TimerPart(1));

        bullet.setShapeX(new float[2]);
        bullet.setShapeY(new float[2]);

        return bullet;
    }

    private void spawnBullet(World world, float x, float y, float rotation) {
        Bullet bullet = new Bullet();
        MovingPart movingPart = new MovingPart(0, 500, 500, 0);
        movingPart.setUp(true);
        bullet.add(movingPart);
        bullet.add(new LifePart(1, 1));
        bullet.add(new PositionPart(x, y, rotation));
        bullet.add(new TimerPart(20));

        world.addEntity(bullet);
    }

    private void updateShape(Entity entity) {
        float[] shapeX = entity.getShapeX();
        float[] shapeY = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapeX[0] = (float) (x + Math.cos(radians) * 1);
        shapeY[0] = (float) (y + Math.sin(radians) * 1);

        shapeX[1] = (float) (x + Math.cos(radians) * 0);
        shapeY[1] = (float) (y + Math.sin(radians) * 0);

        shapeX[2] = (float) (x + Math.cos(radians) * 2);
        shapeY[2] = (float) (y + Math.sin(radians) * 2);

        shapeX[3] = (float) (x + Math.cos(radians) * -2);
        shapeY[3] = (float) (y + Math.sin(radians) * -2);

        entity.setShapeX(shapeX);
        entity.setShapeY(shapeY);
    }
}