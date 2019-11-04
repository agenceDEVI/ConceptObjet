package archi_concept_objet_phil;

public class Case {
	
	private int x;
	private int y;
	
	private CaseType caseType;
	
	private Entity entity;
	
	public Case(int x, int y) {
		caseType = CaseType.WASTELAND;
		this.x = x;
		this.y = y;
	}
	
	public Case(int x, int y, CaseType caseType) {
		this.caseType = caseType;
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public Entity getEntity() {
		return entity;
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
