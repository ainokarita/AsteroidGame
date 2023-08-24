import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.enemysystem.EnemyControlSystem;
import dk.sdu.mmmi.cbse.enemysystem.EnemyPlugin;

module Enemy {
    //requires indicates a module this module depends on
    requires Common;
    //exports indicates a package available publicly within the module
    exports dk.sdu.mmmi.cbse.enemysystem;
    // uses indicates the service interface this module uses.
    provides IEntityProcessingService with EnemyControlSystem;
    provides IGamePluginService with EnemyPlugin;
}