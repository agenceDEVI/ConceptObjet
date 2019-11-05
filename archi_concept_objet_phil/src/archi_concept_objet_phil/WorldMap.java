package archi_concept_objet_phil;

import java.util.ArrayList;
import java.util.Random;

import Personnages.Entity;

public class WorldMap {
	
	private ArrayList<Entity> entities;
	
	private Case[][] worldMap;
	private ArrayList<Case> worldMapList;
	
	public WorldMap() {
		
		worldMap = new Case[Rules.worldMap_maxX][Rules.worldMap_maxY];
		worldMapList = new ArrayList<Case>();
		Random rand = new Random();
		
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
					
					if(rand.nextInt(20)==10) {
						worldMap[i][j]=new Case(i,j,CaseType.OBSTACLE);
					}
					else {
						worldMap[i][j]=new Case(i,j,CaseType.WASTELAND);
					}
					
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
	
	public void checkingCase(int a, int b) {
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (i!=0 || j!=0) {
					this.getCase(a+i, b+j).displayCase();
					System.out.println(this.getCase(a+i, b+j).toString());
				}
			}
		}
	}
	
	
	
}
