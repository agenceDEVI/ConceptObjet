package Personnages;

import java.util.Random;

import archi_concept_objet_phil.Case;
import archi_concept_objet_phil.CaseType;
import archi_concept_objet_phil.Direction;
import archi_concept_objet_phil.Rules;
import archi_concept_objet_phil.WorldMapService;

public abstract class Entity extends EntitySuperClass {
	
	protected int PE;
	protected int PV;
	protected int XP;
	protected Case currentCase;
	protected String race;
	protected int nbrPopulationAlliance;
	protected static boolean alliance;
	
	public abstract void initPV_PE();
	public abstract void attaque(Entity ennemi);
	Random rand = new Random();
	
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
	
	public Direction humanCorner() {
		System.out.println("je cherche");
		switch (rand.nextInt(3)) {
		case 0: System.out.println("BAS"); return Direction.BAS;
		case 1: System.out.println("BASDROITE"); return Direction.BASDROITE;
		case 2: System.out.println("DROITE"); return Direction.DROITE;
		default: return null;
		}
	}
	
	public Direction elveCorner() {
		switch (rand.nextInt(3)) {
		case 0: return Direction.GAUCHE;
		case 1: return Direction.BASGAUCHE;
		case 2: return Direction.BAS;
		default: return null;
		}
	}
	
	public Direction goblinCorner() {
		switch (rand.nextInt(3)) {
		case 0: return Direction.GAUCHE;
		case 1: return Direction.HAUTGAUCHE;
		case 2: return Direction.HAUT;
		default: return null;
		}
	}
	
	public Direction orcCorner() {
		switch (rand.nextInt(3)) {
		case 0: return Direction.HAUT;
		case 1: return Direction.HAUTDROITE;
		case 2: return Direction.DROITE;
		default: return null;
		}
	}
	
	public Direction northLimit() {
		switch (rand.nextInt(5)) {
		case 0: return Direction.GAUCHE;
		case 1: return Direction.BASGAUCHE;
		case 2: return Direction.BAS;
		case 3: return Direction.BASDROITE;
		case 4: return Direction.DROITE;
		default: return null;
		}
	}
	
	public Direction southLimit() {
		switch (rand.nextInt(5)) {
		case 0: return Direction.GAUCHE;
		case 1: return Direction.HAUTGAUCHE;
		case 2: return Direction.HAUT;
		case 3: return Direction.HAUTDROITE;
		case 4: return Direction.DROITE;
		default: return null;
		}
	}
	
	public Direction westLimit() {
		switch (rand.nextInt(5)) {
		case 0: return Direction.HAUT;
		case 1: return Direction.HAUTDROITE;
		case 2: return Direction.DROITE;
		case 3: return Direction.BASDROITE;
		case 4: return Direction.BAS;
		default: return null;
		}
	}
	
	public Direction eastLimit() {
		switch (rand.nextInt(5)) {
		case 0: return Direction.HAUT;
		case 1: return Direction.HAUTGAUCHE;
		case 2: return Direction.GAUCHE;
		case 3: return Direction.BASGAUCHE;
		case 4: return Direction.BAS;
		default: return null;
		}
	}
	
	public Direction center() {
		switch (rand.nextInt(8)) {
		case 0: return Direction.HAUT;
		case 1: return Direction.HAUTGAUCHE;
		case 2: return Direction.GAUCHE;
		case 3: return Direction.BASGAUCHE;
		case 4: return Direction.BAS;
		case 5: return Direction.BASDROITE;
		case 6: return Direction.DROITE;
		case 7: return Direction.HAUTDROITE;
		default: return null;
		}
	}
	
	public void chooseDirection() {
		if(currentCase.getX()==0) {
			if (currentCase.getY()==0) {
				checkingDirection(humanCorner());
			}
			else if (currentCase.getY()==Rules.worldMap_maxY) {
				checkingDirection(orcCorner());
			}
			else {
				checkingDirection(westLimit());
			}
		}
		else if (currentCase.getX()==Rules.worldMap_maxX) {
			if (currentCase.getY()==0) {
				checkingDirection(elveCorner());
			}
			else if (currentCase.getY()==Rules.worldMap_maxY) {
				checkingDirection(goblinCorner());
			}
			else {
				checkingDirection(eastLimit());
			}
		}
		else {
			if (currentCase.getY()==0) {
				checkingDirection(northLimit());
			}
			else if (currentCase.getY()==Rules.worldMap_maxY) {
				checkingDirection(southLimit());
			}
			else {
				checkingDirection(center());
			}
		}
	}
	
	public void checkingDirection(Direction direction) {
		System.out.println(direction);
		switch (direction) {
		case HAUT:
			if(WorldMapService.getMap().checkingCase(currentCase.getX(),currentCase.getY()-1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()-1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()).getEntity(),WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()-1).getEntity(),currentCase.getX(), currentCase.getY()-1);
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX(),currentCase.getY()-1);
			}
			break;
		case HAUTGAUCHE:
			if(WorldMapService.getMap().checkingCase(currentCase.getX()-1,currentCase.getY()-1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()-1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()).getEntity(),WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()-1).getEntity(),currentCase.getX()-1,currentCase.getY()-1);
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX()-1,currentCase.getY()-1);
			}
			break;
		case GAUCHE:
			if(WorldMapService.getMap().checkingCase(currentCase.getX()-1,currentCase.getY())) {
				if (WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()).getEntity(),WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()).getEntity(),currentCase.getX()-1,currentCase.getY());
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX()-1,currentCase.getY());
			}
			break;
		case BASGAUCHE:
			if(WorldMapService.getMap().checkingCase(currentCase.getX()-1,currentCase.getY()+1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()+1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()).getEntity(),WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()+1).getEntity(),currentCase.getX()-1,currentCase.getY()+1);
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX()-1,currentCase.getY()+1);
			}
			break;
		case BAS:
			if(WorldMapService.getMap().checkingCase(currentCase.getX(),currentCase.getY()+1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX(),currentCase.getY()+1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()).getEntity(),WorldMapService.getMap().getCase(currentCase.getX(),currentCase.getY()+1).getEntity(),currentCase.getX(),currentCase.getY()+1);
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX(),currentCase.getY()+1);
			}
			break;
		case BASDROITE:
			if(WorldMapService.getMap().checkingCase(currentCase.getX()+1,currentCase.getY()+1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()+1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()).getEntity(),WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()+1).getEntity(),currentCase.getX()+1,currentCase.getY()+1);
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX()+1,currentCase.getY()+1);
			}
			break;
		case DROITE:
			if(WorldMapService.getMap().checkingCase(currentCase.getX()+1,currentCase.getY())) {
				if (WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()).getEntity(),WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()).getEntity(),currentCase.getX()+1,currentCase.getY());
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX()+1,currentCase.getY());
			}
			break;
		case HAUTDROITE:
			if(WorldMapService.getMap().checkingCase(currentCase.getX()+1,currentCase.getY()-1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()-1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()).getEntity(),WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()-1).getEntity(),currentCase.getX()+1,currentCase.getY()-1);
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX()+1,currentCase.getY()-1);
			}
			break;
		default:
			System.out.println("!!!!!BUG!!!!!!");
		}
	}
	

	
	public void rencontre(Entity attack,Entity defense,int x, int y){
		switch (attack.getClass().getSimpleName()) {
			case "Humain":
				switch (defense.getClass().getSimpleName()){
					case "Humain":
						helpSameRace(attack,defense);
						break;
					case "Elfe":
						helpSameAlliance(attack,defense);
						break;
					default:
						if(WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.HUMAN){
							fight(attack,defense);
						}
						else{
							if(!(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.ORC && defense.getClass().getSimpleName() == "Orc") && !(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.GOBLIN && defense.getClass().getSimpleName() == "Gobelin")  ){
								fight(attack,defense);
							}						
						}
						break;
				}

			case "Elfe":
				switch (defense.getClass().getSimpleName()){
					case "Humain":
						helpSameAlliance(attack,defense);						
						break;
					case "Elfe":
						helpSameRace(attack,defense);
						break;
					default:
						if(WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.ELVE){
							fight(attack,defense);
						}
						else{
							if(!(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.ORC && defense.getClass().getSimpleName() == "Orc") && !(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.GOBLIN && defense.getClass().getSimpleName() == "Gobelin")  ){
								fight(attack,defense);
							}						
						}
						break;
				}
				

			case "Orc":
				switch (defense.getClass().getSimpleName()){
					case "Orc":
						helpSameAlliance(attack,defense);						
						break;
					case "Gobelin":
						helpSameRace(attack,defense);
						break;
					default:
						if(WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.ORC){
							fight(attack,defense);
						}
						else{
							if(!(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.ELVE && defense.getClass().getSimpleName() == "Elfe") && !(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.HUMAN && defense.getClass().getSimpleName() == "Humain")  ){
								fight(attack,defense);
							}						
						}
						break;
				}

			case "Gobelin":
				switch (defense.getClass().getSimpleName()){
					case "Gobelin":
						helpSameAlliance(attack,defense);
						break;
					case "Orc":
						helpSameRace(attack,defense);
						break;
					default:
						if(WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.GOBLIN){
							fight(attack,defense);
						}
						else{
							if(!(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.ELVE && defense.getClass().getSimpleName() == "Elfe") && !(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.HUMAN && defense.getClass().getSimpleName() == "Humain")  ){
								fight(attack,defense);
							}						
						}
						break;
				}
				


		}
	}
	public void helpSameRace(Entity attack,Entity defense){
		if(defense.getPV() > 0 ){
			int PV_redistribue = (defense.getPV() + attack.getPV())/2;
			defense.setPV(PV_redistribue);
			attack.setPV(PV_redistribue);
		}
		else{
			int PE_redistribue = (defense.getPE() + attack.getPE())/2;
			defense.setPE(PE_redistribue);
			attack.setPE(PE_redistribue);
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
	public void helpSameAlliance(Entity attack,Entity defense){
		if(defense.getPV() > 0 ){
			int XP_redistribue = (defense.getXP() + attack.getXP())/2;
			defense.setXP(XP_redistribue);
			this.setXP(XP_redistribue);
		}
		else{
			defense.setPE(1);
			attack.setPE(attack.getPE()-1);
		}
	}

	public void fight(Entity attack,Entity defense){
        while(attack.getPV() > 0 && defense.getPV() >0 ){
            attack.attack(defense);
            defense.getPV();
            defense.attack(attack);
            attack.getPV();

        }
        if(attack.getPV() <= 0 ){
            WorldMapService.getMap().death(attack);
            defense.setXP(defense.getXP() + attack.getXP());
        }
        else{
            WorldMapService.getMap().death(defense);
            defense.setXP(defense.getXP() + attack.getXP());
        }
    }
	
	/**
	 * @return the currentCase
	 */
	public Case getCurrentCase() {
		return currentCase;
	}
	/**
	 * @param currentCase the currentCase to set
	 */
	public void setCurrentCase(Case currentCase) {
		this.currentCase = currentCase;
	}
	public abstract void attack(Entity entitie);
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}

}
