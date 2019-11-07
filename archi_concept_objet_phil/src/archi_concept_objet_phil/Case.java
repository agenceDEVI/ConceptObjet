package archi_concept_objet_phil;

import Personnages.Entity;

public class Case {
	
	private static int nbCase;
	
	private int x;
	private int y;
	
	private CaseType caseType;
	
	private Entity entity;
	
	public Case(int x, int y) {
		caseType = CaseType.WASTELAND;
		this.x = x;
		this.y = y;
		this.entity = null;
		nbCase++;
	}
	
	public Case(int x, int y, CaseType caseType) {
		this.caseType = caseType;
		this.x = x;
		this.y = y;
		this.entity = null;
		nbCase++;
	}
	
	public Case(int x, int y, CaseType caseType, Entity entity) {
		this.caseType = caseType;
		this.x = x;
		this.y = y;
		this.entity = entity;
		nbCase++;
	}
	
	/**
	 * @param entity the entity to set
	 */
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
	/**
	 * @return the entity
	 */
	public Entity getEntity() {
		return entity;
	}	
	
	/**
	 * @return the nbCase
	 */
	public static int getNbCase() {
		return nbCase;
	}

	/**
	 * @return the caseType
	 */
	public CaseType getCaseType() {
		return caseType;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setCaseType(CaseType type) {
		caseType = type;
	}
        
	public boolean canMove(){
		return entity==null;
	}
	
	public void displayCase() {
		switch (caseType) {
		case WASTELAND:
			System.out.print(" ⭙ ");
			break;
		case ELVE:
			System.out.print(" ➳ ");
			break;
		case HUMAN:
			System.out.print(" ⛑ ");
			break;
		case GOBLIN:
			System.out.print(" ☭ ");
			break;
		case ORC:
			System.out.print(" ☠  ");
			break;
		case OBSTACLE:
			System.out.print(" W");
		default:
			break;
		}
	}
	
	@Override
	public String toString() {
		return "Coord x:"+this.getX()+"; Coord y:"+this.getY();
	}
	

}
