package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 *
 * @author jcs
*/
public interface IPostEntityProcessingService  {
        /**
         * @param gameData  stores time since last update and size of screen
         * @param world     contains entities and vector data for drawing the game field
         */
        void process(GameData gameData, World world);
}
