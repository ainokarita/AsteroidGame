module Core {
    //requires indicates a module this module depends on
    requires Common;
    requires com.badlogic.gdx;

 //   requires gdx.backend.lwjgl; // This fixed the issue with clean install not finding libgdx package

// uses indicates the service interface this module uses.
    uses dk.sdu.mmmi.cbse.common.services.IGamePluginService;
    uses dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
    uses dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
}