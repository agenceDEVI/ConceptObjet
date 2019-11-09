package archi_concept_objet_phil;

import java.lang.reflect.Constructor;

public final class Position {
	
	private int coordonneeX;
	private int coordonneeY;
	
	public Position(int coordonneeX, int coordonneeY) {
		this.coordonneeX=coordonneeX;
		this.coordonneeY=coordonneeY;
	}

	/**
	 * @return the coordonneeX
	 */
	public int getCoordonneeX() {
		return coordonneeX;
	}

	/**
	 * @param coordonneeX the coordonneeX to set
	 */
	public void setCoordonneeX(int coordonneeX) {
		this.coordonneeX = coordonneeX;
	}

	/**
	 * @return the coordonneeY
	 */
	public int getCoordonneeY() {
		return coordonneeY;
	}

	/**
	 * @param coordonneeY the coordonneeY to set
	 */
	public void setCoordonneeY(int coordonneeY) {
		this.coordonneeY = coordonneeY;
	}
	
}
