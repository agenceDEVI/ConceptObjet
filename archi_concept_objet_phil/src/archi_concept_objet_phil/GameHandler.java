package archi_concept_objet_phil;

import java.util.Random;

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
		/*Orc orc = new Orc();
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
		System.out.println("Nb de gobelin :"+ Gobelin.getNbGoblelin());*/
		System.out.println();
		System.out.println(worldMap.getCase(0, 0).getEntity());
		System.out.println("je veux");
		worldMap.getCase(0, 0).getEntity().chooseDirection();
		System.out.println("BAS "+worldMap.getCase(0, 1).getEntity());
		System.out.println("BASDROITE "+worldMap.getCase(1, 1).getEntity());
		System.out.println("DROITE "+worldMap.getCase(1, 0).getEntity());
		//orc.attaque(worldMap.getCase(0, 0).getEntity());
		//System.out.println("Nb PV humain :"+ worldMap.getCase(0, 0).getEntity().getPV());
		//worldMap.getCase(0, 0).getEntity().deplacement(worldMap.getCase(0, 0));
		//worldMap.deplacement();
		
		System.out.println();
		worldMap.displayWorldMap();
		//System.out.println("Nb PV humain :"+ worldMap.getCase(10, 10).getEntity().getPV());
		
		
		
	}

}
