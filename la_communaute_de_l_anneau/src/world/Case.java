package world;

import elements.*;

public class Case {
	
	private int coordY;
	private int coordX;
	private Element type;
	private boolean taken;
	
	public Case(int pCooordY, int pCoordX, Element pType)
	  {
	    //System.out.println("Création d'une case avec des paramètres !");
		coordY = pCooordY;
		coordX = pCoordX;
	    type = pType;
	    taken = false;
	  }   
	
	public void displayCase() {
		//System.out.print("("+this.coordY+","+this.coordX+","+this.type+")");
		type.displayIdentity();
	}
}
