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
	
	public Entity getEntity() {
		return entity;
	}
	
	public void setCaseType(CaseType type) {
		caseType = type;
	}
	
	@Override
	public String toString() {
		return "Coord x:"+x+"; Coord y:"+y;
	}
}
