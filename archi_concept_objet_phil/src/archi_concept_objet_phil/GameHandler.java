package archi_concept_objet_phil;

import java.util.Random;

import Personnages.Gobelin;
import Personnages.Humain;
import Personnages.Orc;

public class GameHandler {

	public static void main(String[] args) {
            
		WorldMapService.getMap();
		while(!WorldMapService.getMap().isGameOver()){
			WorldMapService.getMap().playOneTurn();
		}
		
		// tout ce qui est après c'est du test
		WorldMapService.getMap().displayWorldMap();
		System.out.println();
		
		WorldMapService.getMap().checkingCase(4, 4);
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
		System.out.println(WorldMapService.getMap().getCase(0, 0).getEntity());
		System.out.println("je veux");
		WorldMapService.getMap().getCase(0, 0).getEntity().chooseDirection();
		System.out.println("BAS "+WorldMapService.getMap().getCase(0, 1).getEntity());
		System.out.println("BASDROITE "+WorldMapService.getMap().getCase(1, 1).getEntity());
		System.out.println("DROITE "+WorldMapService.getMap().getCase(1, 0).getEntity());
		//orc.attaque(worldMap.getCase(0, 0).getEntity());
		//System.out.println("Nb PV humain :"+ worldMap.getCase(0, 0).getEntity().getPV());
		//worldMap.getCase(0, 0).getEntity().deplacement(worldMap.getCase(0, 0));
		//worldMap.deplacement();
		
		System.out.println();
		WorldMapService.getMap().displayWorldMap();
		GameManager game = new GameManager(WorldMapService.getMap());
		//System.out.println("Nb PV humain :"+ worldMap.getCase(10, 10).getEntity().getPV());
		
		
		
	}

}
