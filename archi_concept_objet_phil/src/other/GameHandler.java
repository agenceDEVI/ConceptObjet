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
		GameManager game = new GameManager(WorldMapService.getMap());
		game.deroulementPartie();
		//System.out.println("Nb PV humain :"+ worldMap.getCase(10, 10).getEntity().getPV());
		
		
		
	}

}
