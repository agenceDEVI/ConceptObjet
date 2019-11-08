package archi_concept_objet_phil;

import Personnages.Elfe;
import Personnages.Entity;
import Personnages.Gobelin;
import Personnages.Humain;
import Personnages.Orc;
import java.util.concurrent.TimeUnit;

public class GameManager {
	
	public WorldMap worldMap;
	private boolean victoire = false;
	
	public GameManager(WorldMap worldMap){
		this.worldMap = worldMap;
	}
	
	public void deroulementPartie() {//throws InterruptedException{
		worldMap.positionnementEntity();
		int compteurTour = 0;
		while( ((Humain.getNbHumain()+Elfe.getNbElfe()) > 0 && (Orc.getNbOrc()+Gobelin.getNbGoblelin()) > 0) || compteurTour <1000){
			for(int i=0;i<worldMap.entities.size();i++/*Entity e : worldMap.entities*/){
				worldMap.entities.get(i).chooseDirection();
				WorldMapService.getMap().displayWorldMap();
				System.out.println("nouveau tour");
				//TimeUnit.SECONDS.sleep(2);
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
