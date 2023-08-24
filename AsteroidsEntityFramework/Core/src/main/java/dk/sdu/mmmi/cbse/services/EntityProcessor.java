package dk.sdu.mmmi.cbse.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

@Service("entityProcessor")
public class EntityProcessor implements Processor{
    @Override
    public void process(GameData gameData, World world) {
        List<IEntityProcessingService> plugins = ServiceLoader.load(IEntityProcessingService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
        for (IEntityProcessingService plugin : plugins) {
            plugin.process(gameData, world);
        }
    }
}