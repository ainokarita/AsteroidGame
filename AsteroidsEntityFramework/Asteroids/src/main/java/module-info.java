import dk.sdu.mmmi.cbse.common.services.IAsteroidsSplitter;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Asteroid {
    requires Common;
    exports dk.sdu.mmmi.cbse.asteroidssystem;
    provides IGamePluginService with dk.sdu.mmmi.cbse.asteroidssystem.AsteroidsPlugin;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.asteroidssystem.AsteroidsControl;
    provides IAsteroidsSplitter with dk.sdu.mmmi.cbse.asteroidssystem.AsteroidsSplitter;
}