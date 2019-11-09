package other;

public class GameHandler {

	public static void main(String[] args) {
            
		WorldMapService.getMap();
		GameManager game = new GameManager(WorldMapService.getMap());
		game.deroulementPartie();
		//System.out.println("Nb PV humain :"+ worldMap.getCase(10, 10).getEntity().getPV());
		
		
		
	}

}
