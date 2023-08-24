import dk.sdu.mmmi.cbse.common.services.BulletSPI;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;


module Enemy {
    //requires indicates a module this module depends on
    requires Common;
    uses BulletSPI;
    //exports indicates a package available publicly within the module
    exports dk.sdu.mmmi.cbse.enemysystem;
    // uses indicates the service interface this module uses.
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.enemysystem.EnemyControlSystem;
    provides IGamePluginService with dk.sdu.mmmi.cbse.enemysystem.EnemyPlugin;
}
