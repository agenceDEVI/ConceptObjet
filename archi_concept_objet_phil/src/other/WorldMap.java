package archi_concept_objet_phil;

import java.util.ArrayList;
import java.util.Random;

import javax.sound.midi.Soundbank;

import Personnages.Elfe;
import Personnages.Entity;
import Personnages.Gobelin;
import Personnages.Humain;
import Personnages.Orc;

public class WorldMap {
	
	Random rand = new Random();
	
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	
	private Case[][] worldMap;
	private ArrayList<Case> worldMapList;
	private int nbEntities;
	
	public WorldMap() {
		
		worldMap = new Case[Rules.worldMap_maxX][Rules.worldMap_maxY];
		worldMapList = new ArrayList<Case>();
		generation();
		//positionnementEntity();
		for(int i = 0; i < Rules.worldMap_maxX; i++) {
			for(int j = 0; j < Rules.worldMap_maxY; j++) {
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
		//Première coordonnée X de la première case
		int posX = worldMapList.get(0).getX();
		/*for (Case mapCase : worldMapList) {
			if(mapCase.getX()!=posX) { //Si le X change on change de ligne
				System.out.println();
				posX+=1;
			}
			if(mapCase.getEntity()==null) {
				mapCase.displayCase();
			}
			else {
				System.out.print(mapCase.getEntity().toString());
			}
		}*/
		
		for (int i = 0; i < Rules.worldMap_maxY; i++) {
			for (int j = 0; j < Rules.worldMap_maxX; j++) {
				
				if(worldMap[i][j].getEntity()==null) {
					worldMap[i][j].displayCase();
				}
				else {
					System.out.print(worldMap[i][j].getEntity().toString());
				}
			}
			System.out.println();
		}
		System.out.println();
	} 
	
	public boolean checkingCase(int a, int b) {
		//System.out.println("a="+a+" b="+b);
		if(this.getCase(b, a).getCaseType()==CaseType.OBSTACLE) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void generation(){
		
		for(int i = 0; i < Rules.worldMap_maxX; i++) {
			for(int j = 0; j < Rules.worldMap_maxY; j++) {
				if(i<Rules.worldMap_sizeSafeZone && j<Rules.worldMap_sizeSafeZone) {
					worldMap[j][i]=new Case(j,i,CaseType.HUMAN);
				}
				else if (i<Rules.worldMap_sizeSafeZone && j>(Rules.worldMap_maxX-(1+Rules.worldMap_sizeSafeZone))) {
					worldMap[j][i]=new Case(j,i,CaseType.ELVE);
				}
				else if (i>(Rules.worldMap_maxY-(1+Rules.worldMap_sizeSafeZone)) && j<Rules.worldMap_sizeSafeZone) {
					worldMap[j][i]=new Case(j,i,CaseType.GOBLIN);
				}
				else if (i>(Rules.worldMap_maxY-(1+Rules.worldMap_sizeSafeZone)) && j>(Rules.worldMap_maxX-(1+Rules.worldMap_sizeSafeZone))) {
					worldMap[j][i]=new Case(j,i,CaseType.ORC);
				}
				else {
					
					if(rand.nextInt(20)==10) {
						worldMap[j][i]=new Case(j,i,CaseType.OBSTACLE);
					}
					else {
						worldMap[j][i]=new Case(j,i,CaseType.WASTELAND);
					}
					
				}
				//worldMap[i][j] = new Case(i,j);
				//worldMapList.add(worldMap[i][j]);
			}
		}
		//return worldMap;
	}
	
	public void positionnementEntity() {
		nbEntities=0;
		for(int i = 0; i < Rules.worldMap_maxX; i++) {
			for(int j = 0; j < Rules.worldMap_maxY; j++) {
				switch (worldMap[i][j].getCaseType()) {
				case HUMAN:
					if (rand.nextInt(6)==1) {
						Humain humain = new Humain(worldMap[i][j]);
						worldMap[i][j].setEntity(humain);
						entities.add(humain);
						nbEntities++;
					}
					break;
				case ELVE:
					if (rand.nextInt(7)==1) {
						Elfe elfe = new Elfe(worldMap[i][j]);
						worldMap[i][j].setEntity(elfe);
						entities.add(elfe);
						nbEntities++;
						}
					break;
				case ORC:
					if (rand.nextInt(8)==1) {
						Orc orc = new Orc(worldMap[i][j]);
						worldMap[i][j].setEntity(orc);
						entities.add(orc);
						nbEntities++;
					}
					break;
				case GOBLIN:
					if (rand.nextInt(3)==1) {
						Gobelin gobelin = new Gobelin(worldMap[i][j]);
						worldMap[i][j].setEntity(gobelin);
						entities.add(gobelin);
						nbEntities++;
					}
					break;
				default:
					break;
				}
			}
		}
		
	}
	
	/**
	 * @return the entities
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	/**
	 * @param entities the entities to set
	 */
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public void death(Entity entity){
		System.out.println("death : ");
        for(int i=0; i<entities.size();i++){
            if(entities.get(i) == entity){
            	worldMap[entities.get(i).getCurrentCase().getX()][entities.get(i).getCurrentCase().getY()].setEntity(null);
            	switch (entities.get(i).getClass().getSimpleName()){
				case "Humain":
                	Humain.setNbHumain(Humain.getNbHumain()-1);
                	break;
                
            	case "Elfe":
                    Elfe.setNbElfe(Elfe.getNbElfe()-1);
                    break;
            	case "Orc":
                    Orc.setNbOrc(Orc.getNbOrc()-1);
                    break;
            	case "Gobelin":
                    Gobelin.setNbGoblelin(Gobelin.getNbGoblelin()-1);
                	break;
                }
                entities.remove(i);
            }
        }
    }
	
	public void move(int previousX, int previousY, int nextX, int nextY) {
		//System.out.println("je bouge");
		worldMap[nextX][nextY].setEntity(worldMap[previousX][previousY].getEntity());
		worldMap[nextX][nextY].getEntity().setCurrentCase(worldMap[nextX][nextY]);
		//System.out.println("Je suis dans move"+worldMap[previousX][previousY].getEntity()+" //// "+worldMap[nextX][nextY].getEntity());
		worldMap[previousX][previousY].setEntity(null);
		/*System.out.println("je test maintenant"+worldMap[previousX][previousY].getEntity()+" //// "+worldMap[nextX][nextY].getEntity());
		System.out.println(previousX+"test"+previousY+"test"+nextX+"test"+nextY);
		System.out.println("BAS "+this.getCase(0, 1).getEntity());
		System.out.println("BASDROITE "+this.getCase(1, 1).getEntity());
		System.out.println("DROITE "+this.getCase(1, 0).getEntity());*/
	}

	public int getNbEntities() {
		return nbEntities;
	}

	public void setNbEntities(int nbEntities) {
		this.nbEntities = nbEntities;
	}
}
