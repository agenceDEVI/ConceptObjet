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
				if(i<Rules.worldMap_sizeSafeZone && j<Rules.worldMap_sizeSafeZone) {
					worldMap[i][j]=new Case(i,j,CaseType.HUMAN);
				}
				else if (i<Rules.worldMap_sizeSafeZone && j>(Rules.worldMap_maxX-(1+Rules.worldMap_sizeSafeZone))) {
					worldMap[i][j]=new Case(i,j,CaseType.ELVE);
				}
				else if (i>(Rules.worldMap_maxY-(1+Rules.worldMap_sizeSafeZone)) && j<Rules.worldMap_sizeSafeZone) {
					worldMap[i][j]=new Case(i,j,CaseType.GOBLIN);
				}
				else if (i>(Rules.worldMap_maxY-(1+Rules.worldMap_sizeSafeZone)) && j>(Rules.worldMap_maxX-(1+Rules.worldMap_sizeSafeZone))) {
					worldMap[i][j]=new Case(i,j,CaseType.ORC);
				}
				
				else {
					worldMap[i][j]=new Case(i,j,CaseType.WASTELAND);
				}
				//worldMap[i][j] = new Case(i,j);
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
        
        public Case getCase(int x,int y){
            return worldMap[x][y];
        
        }
	
	public void displayWorldMap() {
		System.out.println("Affichage de la carte:");
		int posX = worldMapList.get(0).getX();
		for (Case mapCase : worldMapList) {
			if(mapCase.getX()!=posX) {
				System.out.println();
				posX+=1;
			}
			mapCase.displayCase();
		}
		System.out.println();
	}
	
}
