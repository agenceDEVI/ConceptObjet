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
		while( Humain.getNbHumain()+Elfe.getNbElfe() > 0 && Orc.getNbOrc()+Gobelin.getNbGoblelin() > 0 && compteurTour <10000 ){
			System.out.println(worldMap.getNbEntities());
			
			for(int i=0;i<worldMap.getNbEntities();i++/*Entity e : worldMap.entities*/){
					System.out.println("################################################################");
					System.out.println("Nb Entité : "+worldMap.getNbEntities());
					System.out.println(worldMap.getEntities().get(i));
					System.out.println("entité numéro : "+i);
					System.out.println(worldMap.getEntities().get(i).getCurrentCase().toString());
					System.out.println("getX :"+worldMap.getEntities().get(i).getCurrentCase().getX());
					System.out.println("getY :"+worldMap.getEntities().get(i).getCurrentCase().getY());
					WorldMapService.getMap().displayWorldMap();
					worldMap.getEntities().get(i).chooseDirection();
					compteurTour++;
					System.out.println("nouveau tour"+compteurTour);
					/*try {
						TimeUnit.MICROSECONDS.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
				}
			/*try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		if(Humain.getNbHumain()+Elfe.getNbElfe() < 0){
			System.out.println("Les méchants Win");
		}
		else if(Orc.getNbOrc()+Gobelin.getNbGoblelin() < 0){
			System.out.println("Les gentils Win");
		}
		else{
			System.out.println("Match Nul");
		}
		}
}
