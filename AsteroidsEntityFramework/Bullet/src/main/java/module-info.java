import dk.sdu.mmmi.cbse.common.services.BulletSPI;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Bullet {
    requires Common;
    //indicates a package available publicly within the module
    exports dk.sdu.mmmi.cbse.bullet;
    provides IGamePluginService with dk.sdu.mmmi.cbse.bullet.BulletPlugin;
    provides BulletSPI with dk.sdu.mmmi.cbse.bullet.BulletControl;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.bullet.BulletControl;
}