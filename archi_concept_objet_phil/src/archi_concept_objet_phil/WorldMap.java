package archi_concept_objet_phil;

import java.util.ArrayList;

public class WorldMap {
	
	private ArrayList<Entity> entities;
	
	private Case[][] worldMap;
	private ArrayList<Case> worldMapList;
	
	public WorldMap() {
		
		worldMap = new Case[Rules.worldMap_maxX][Rules.worldMap_maxY];
		worldMapList = new ArrayList<Case>();
		
		for(int i = 0; i < Rules.worldMap_maxX; i++) {
			for(int j = 0; j < Rules.worldMap_maxY; j++) {
				worldMap[i][j] = new Case(i,j);
				worldMapList.add(worldMap[i][j]);
			}
		}
		
		entities = new ArrayList<Entity>();
		
	}
	
	public void playOneTurn() {
		
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).play();
		}
		
	}
	
	public boolean isGameOver() {
		//waw
		return true;
	}
	
}
