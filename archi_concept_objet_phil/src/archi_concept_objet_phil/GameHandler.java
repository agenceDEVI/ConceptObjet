package archi_concept_objet_phil;

import Personnages.Gobelin;
import Personnages.Humain;
import Personnages.Orc;

public class GameHandler {

	public static void main(String[] args) {
            
		WorldMap worldMap = new WorldMap();
		while(!worldMap.isGameOver()){
			worldMap.playOneTurn();
		}
		
		// tout ce qui est après c'est du test
		worldMap.displayWorldMap();
		System.out.println();
		worldMap.checkingCase(4, 4);
		System.out.println();
		Orc orc = new Orc();
		Humain humain = new Humain();
		Gobelin gobelin = new Gobelin();
		System.out.println("Nb PV Paul :"+ humain.getPV());
		System.out.println("Nb PV Jules :"+ orc.getPV());
		System.out.println("Nb PV Thibault :"+ gobelin.getPV());
		orc.attaque(humain);
		System.out.println("Nb PV Paul :"+ humain.getPV());
		System.out.println("Nb PV Jules :"+ orc.getPV());
		System.out.println("Nb PV Thibault :"+ gobelin.getPV());
		gobelin.attaque(humain);
		gobelin.attaque(orc);
		System.out.println("Nb PV Paul :"+ humain.getPV());
		System.out.println("Nb PV Jules :"+ orc.getPV());
		System.out.println("Nb PV Thibault :"+ gobelin.getPV());
		System.out.println();
		System.out.println("Nb de gobelin :"+ Gobelin.getNbGoblelin());
		Gobelin gobelin1 = new Gobelin();
		System.out.println("Nb de gobelin :"+ Gobelin.getNbGoblelin());
		
		
	}

}
