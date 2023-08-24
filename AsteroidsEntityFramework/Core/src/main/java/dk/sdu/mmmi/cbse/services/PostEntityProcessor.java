package dk.sdu.mmmi.cbse.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

@Service("postEntityProcessor")
public class PostEntityProcessor implements Processor{
    @Override
    public void process(GameData gameData, World world) {
        List<IPostEntityProcessingService> plugins = ServiceLoader.load(IPostEntityProcessingService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
        for (IPostEntityProcessingService plugin : plugins) {
            plugin.process(gameData, world);
        }
    }
}