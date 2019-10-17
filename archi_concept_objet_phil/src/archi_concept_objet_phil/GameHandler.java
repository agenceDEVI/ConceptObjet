package archi_concept_objet_phil;

public class GameHandler {

	public static void main(String[] args) {
            
            while(!WorldMapService.getMap().isGameOver()){
                WorldMapService.getMap().playOneTurn();
                
            }
            
	
	}

}
