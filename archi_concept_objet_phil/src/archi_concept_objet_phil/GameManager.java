package archi_concept_objet_phil;

import Personnages.Elfe;
import Personnages.Entity;
import Personnages.Gobelin;
import Personnages.Humain;
import Personnages.Orc;
import java.util.concurrent.TimeUnit;

public class GameManager {
	
	public WorldMap worldMap;
	public GameManager(WorldMap worldMap){
		this.worldMap = worldMap;
	}
	
	public void deroulementPartie() {//throws InterruptedException{
		worldMap.positionnementEntity();
		int compteurTour = 0;
		int allie = Humain.getNbHumain()+Elfe.getNbElfe();
		int ennemi = Orc.getNbOrc()+Gobelin.getNbGoblelin();
		while( allie > 0 && ennemi > 0 && compteurTour <1000 ){
			System.out.println(worldMap.getNbEntities());
			System.out.println("nbhulain"+Humain.getNbHumain());
			System.out.println("nbgobelin"+Gobelin.getNbGoblelin());
			for(int i=0;i<worldMap.getNbEntities();i++/*Entity e : worldMap.entities*/){
				System.out.println(worldMap.getNbEntities());
					System.out.println(i);
					System.out.println(worldMap.getEntities().get(i));
					WorldMapService.getMap().displayWorldMap();
					worldMap.getEntities().get(i).chooseDirection();
					compteurTour++;
					System.out.println("nouveau tour"+compteurTour);
					allie = Humain.getNbHumain()+Elfe.getNbElfe();
					ennemi = Orc.getNbOrc()+Gobelin.getNbGoblelin();
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
