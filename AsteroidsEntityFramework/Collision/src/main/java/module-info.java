import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    //indicates a package available publicly within the module
    exports dk.sdu.mmmi.cbse.collision;

    provides IPostEntityProcessingService with dk.sdu.mmmi.cbse.collision.CollisionDetection;
}