/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archi_concept_objet_phil;

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
