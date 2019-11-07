package Personnages;

import archi_concept_objet_phil.Case;
import archi_concept_objet_phil.CaseType;
import archi_concept_objet_phil.Direction;
import archi_concept_objet_phil.WorldMapService;

public abstract class Entity {
	
	protected int PE;
	protected int PV;
	protected int XP;
	private Case currentCase;
	
	protected int nbrPopulationAlliance;
	protected static boolean alliance;
	
	public abstract void initPV_PE();
	public abstract void attaque(Entity ennemi);
	
	/**
	 * @return the pV
	 */
	public int getPV() {
		return PV;
	}
	public boolean play(){
            
            return WorldMapService.getMap().getCase(2,2).canMove();
        
        }
        // Abstract au cas où les 4 classes jouent differemment 
	
        // Verifier si on peut bien se deplacer : 
        
        
	/**
	 * @return the alliance
	 */
	public static boolean isAlliance() {
		return alliance;
	}
	
	public void checkingDirection(Direction direction) {
		switch (direction) {
		case HAUT:
			if(WorldMapService.getMap().checkingCase(currentCase.getX(),currentCase.getY()+1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()+1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()+1).getEntity(),currentCase.getX(), currentCase.getY()+1);
				}
				else move(currentCase.getX(),currentCase.getY()+1);
			}
		case HAUTGAUCHE:
			if(WorldMapService.getMap().checkingCase(currentCase.getX()-1,currentCase.getY()+1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()+1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()+1).getEntity(),currentCase.getX()-1,currentCase.getY()+1);
				}
				else move(currentCase.getX()-1,currentCase.getY()+1);
			}
		case GAUCHE:
			if(WorldMapService.getMap().checkingCase(currentCase.getX()-1,currentCase.getY())) {
				if (WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()).getEntity(),currentCase.getX()-1,currentCase.getY());
				}
				else move(currentCase.getX()-1,currentCase.getY());
			}
		case BASGAUCHE:
			if(WorldMapService.getMap().checkingCase(currentCase.getX()-1,currentCase.getY()-1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()-1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()-1).getEntity(),currentCase.getX()-1,currentCase.getY()-1);
				}
				else move(currentCase.getX()-1,currentCase.getY()-1);
			}
		case BAS:
			if(WorldMapService.getMap().checkingCase(currentCase.getX(),currentCase.getY()-1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX(),currentCase.getY()-1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(),currentCase.getY()-1).getEntity(),currentCase.getX(),currentCase.getY()-1);
				}
				else move(currentCase.getX(),currentCase.getY()-1);
			}
		case BASDROITE:
			if(WorldMapService.getMap().checkingCase(currentCase.getX()+1,currentCase.getY()-1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()-1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()-1).getEntity(),currentCase.getX()+1,currentCase.getY()-1);
				}
				else move(currentCase.getX()+1,currentCase.getY()-1);
			}
		case DROITE:
			if(WorldMapService.getMap().checkingCase(currentCase.getX()+1,currentCase.getY())) {
				if (WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()).getEntity(),currentCase.getX()+1,currentCase.getY());
				}
				else move(currentCase.getX()+1,currentCase.getY());
			}
		case HAUTDROITE:
			if(WorldMapService.getMap().checkingCase(currentCase.getX()+1,currentCase.getY()+1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()+1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()+1).getEntity(),currentCase.getX()+1,currentCase.getY()+1);
				}
				else move(currentCase.getX()+1,currentCase.getY()+1);
			}
		default:
			System.out.println("!!!!!BUG!!!!!!");
		}
	}
	
	public void move(int x, int y) {
		Case nextCase = WorldMapService.getMap().getCase(x, y);
		nextCase.setEntity(this);
		currentCase.setEntity(null);
		this.currentCase = nextCase;
	}
	
	public void rencontre(Entity entity,int x, int y){
		switch (entity.getClass().getSimpleName().toString()) {
			case "Humain":
				if(this.getClass().getSimpleName().toString() == "Humain"){
					helpSameRace(entity);
				}
				if(this.getClass().getSimpleName().toString() == "Elfe"){
					helpSameAlliance(entity);
				}
				else{
					if(WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.HUMAN){
						fight(entity);
					}
					else{
						if(!(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.ORC && entity.getClass().getSimpleName().toString() == "Orc") && !(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.GOBLIN && entity.getClass().getSimpleName().toString() == "Gobelin")  ){
							fight(entity);
						}
					}
					
				}
			case "Elfe":
				if(this.getClass().getSimpleName().toString() == "Elfe"){
					helpSameRace(entity);
				}
				if(this.getClass().getSimpleName().toString() == "Humain"){
					helpSameAlliance(entity);
				}
				else{
					if(WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.ELVE){
						fight(entity);
					}
					else{
						if(!(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.ORC && entity.getClass().getSimpleName().toString() == "Orc") || !(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.GOBLIN && entity.getClass().getSimpleName().toString() == "Gobelin")  ){
							fight(entity);
						}
					}
				}
			case "Orc":
				if(this.getClass().getSimpleName().toString() == "Orc"){
					helpSameRace(entity);
				}
				if(this.getClass().getSimpleName().toString() == "Gobelin"){
					helpSameAlliance(entity);
				}
				else{
					if(WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.ORC){
						fight(entity);
					}
					else{
						if(!(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.ELVE && entity.getClass().getSimpleName().toString() == "Elfe") || !(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.HUMAN && entity.getClass().getSimpleName().toString() == "Humain")  ){
							fight(entity);
						}
					}
				}
			case "Gobelin":
				if(this.getClass().getSimpleName().toString() == "Gobelin"){
					helpSameRace(entity);
				}
				if(this.getClass().getSimpleName().toString() == "Orc"){
					helpSameAlliance(entity);
				}
				else{
					if(WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.GOBLIN){
						fight(entity);
					}
					else{
						if(!(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.ELVE && entity.getClass().getSimpleName().toString() == "Elfe") || !(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.HUMAN && entity.getClass().getSimpleName().toString() == "Humain")  ){
							fight(entity);
						}
					}
				}
		}
	}
	public void helpSameRace(Entity entity){
		if(entity.getPV() > 0 ){
			int PV_redistribue = (entity.getPV() + this.getPV())/2;
			entity.setPV(PV_redistribue);
			this.setPV(PV_redistribue);
		}
		else{
			int PE_redistribue = (entity.getPE() + this.getPE())/2;
			entity.setPE(PE_redistribue);
			this.setPE(PE_redistribue);
		}
	}

	/**
	 * @return the pE
	 */
	public int getPE() {
		return PE;
	}
	/**
	 * @param pE the pE to set
	 */
	public void setPE(int pE) {
		PE = pE;
	}
	/**
	 * @return the xP
	 */
	public int getXP() {
		return XP;
	}
	/**
	 * @param xP the xP to set
	 */
	public void setXP(int xP) {
		XP = xP;
	}
	/**
	 * @param pV the pV to set
	 */
	public void setPV(int pV) {
		PV = pV;
	}
	public void helpSameAlliance(Entity entity){
		if(entity.getPV() > 0 ){
			int XP_redistribue = (entity.getXP() + this.getXP())/2;
			entity.setXP(XP_redistribue);
			this.setXP(XP_redistribue);
		}
		else{
			entity.setPE(1);
			this.setPE(this.getPE()-1);
		}
	}
	public void fight(Entity entity){
		while(this.getPV() > 0 || entity.getPV() >0 ){
			this.attack();
			entity.attack();
		}
		if(this.getPV() <= 0 ){
			WorldMapService.getMap().death(this);
		}
		else{
			WorldMapService.getMap().death(entity);
		}
	}

	public void attack() {};

}
