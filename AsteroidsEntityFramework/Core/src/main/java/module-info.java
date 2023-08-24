module Core {
    //requires indicates a module this module depends on
    requires Common;
    requires java.desktop;
    requires com.badlogic.gdx;
    requires spring.context;
    requires spring.beans;

    exports dk.sdu.mmmi.cbse.services;
    exports dk.sdu.mmmi.cbse.main;
// uses indicates the service interface this module uses.
    uses dk.sdu.mmmi.cbse.common.services.IGamePluginService;
    uses dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
    uses dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

    //   requires gdx.backend.lwjgl; // This fixed the issue with clean install not finding libgdx package
}