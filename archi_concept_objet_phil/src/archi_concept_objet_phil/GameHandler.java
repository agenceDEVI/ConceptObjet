package archi_concept_objet_phil;

public class GameHandler {

	public static void main(String[] args) {
		
		WorldMap worldMap = new WorldMap();
		while(!worldMap.isGameOver()) {
			worldMap.playOneTurn();
		}
	
	}

}
