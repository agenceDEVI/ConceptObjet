package archi_concept_objet_phil;

import Personnages.Elfe;
import Personnages.Entity;
import Personnages.Gobelin;
import Personnages.Humain;
import Personnages.Orc;

public class GameManager {
	
	public WorldMap worldMap;
	private boolean victoire = false;
	
	public GameManager(WorldMap worldMap){
		this.worldMap = worldMap;
	}
	
	public void deroulementPartie(){
		worldMap.positionnementEntity();
		int compteurTour = 0;
		while( ((Humain.getNbHumain()+Elfe.getNbElfe()) > 0 && (Orc.getNbOrc()+Gobelin.getNbGoblelin()) > 0) || compteurTour <1000){
			for(Entity e : worldMap.entities){
				e.chooseDirection();
			}
		}
		if(Humain.getNbHumain()+Elfe.getNbElfe() > 0){
			System.out.println("Les gentils Win");
		}
		else if(Orc.getNbOrc()+Gobelin.getNbGoblelin() > 0){
			System.out.println("Les méchants Win");
		}
		else{
			System.out.println("Match Nul");
		}
	}
}
