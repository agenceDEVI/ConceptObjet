package archi_concept_objet_phil;

public class GameHandler {

	public static void main(String[] args) {
            
		WorldMap worldMap = new WorldMap();
		worldMap.displayWorldMap();
		System.out.println();
		worldMap.checkingCase(4, 4);
		while(!worldMap.isGameOver()){
			worldMap.playOneTurn();
		}
            
	
	}

}
