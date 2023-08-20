package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IGamePluginService {
    /**
     *
     * @param gameData  stores time since last update and size of screen
     * @param world     contains entities and vector data for drawing the game field
     */

    void start(GameData gameData, World world);

    /**
     *
     * @param gameData stores time since last update and size of screen
     * @param world contains entities and vector data for drawing the game field
     */

    void stop(GameData gameData, World world);
}
