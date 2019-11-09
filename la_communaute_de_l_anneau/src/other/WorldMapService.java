package other;

/**
 *
 * @author ISEN
 */
public class WorldMapService {
    
    private static final WorldMap
            worldMap = new WorldMap();
    
    private WorldMapService(){};
    
    public static WorldMap getMap(){
        return worldMap;
    }
    
}
