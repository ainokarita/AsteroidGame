package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * This interface provides the contract for
 * processing game entities in the game world.
 * PRE-CONDITION: The entity must not be null.
 * POST-CONDITION: The entity has been processed and updated as necessary.
 *
 */

public interface IEntityProcessingService {

    /**
     * Processes the given entity.
     *
     * @param gameData stores time since last update and size of screen
     * @param world contains entities and vector data for drawing the game field
    */

    void process(GameData gameData, World world);
}
