import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Bullet {
    requires Common;
    //indicates a package available publicly within the module
    exports dk.sdu.mmmi.cbse.bullet;

    provides IGamePluginService with dk.sdu.mmmi.cbse.bullet.BulletPlugin;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.bullet.BulletControl;

}