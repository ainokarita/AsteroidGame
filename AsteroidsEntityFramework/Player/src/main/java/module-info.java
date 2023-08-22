import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Player {
    //requires indicates a module this module depends on
    requires Common;
    //exports indicates a package available publicly within the module
    exports dk.sdu.mmmi.cbse.playersystem;

// uses indicates the service interface this module uses.
    provides IGamePluginService with dk.sdu.mmmi.cbse.playersystem.PlayerPlugin;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.playersystem.PlayerControlSystem;

}