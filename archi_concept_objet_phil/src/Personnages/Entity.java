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
	protected static int nbrPopulationAlliance;
	public static int getNbrPopulationAlliance() {
		return nbrPopulationAlliance;
	}
	public static void setNbrPopulationAlliance(int nbrPopulationAlliance) {
		Entity.nbrPopulationAlliance = nbrPopulationAlliance;
	}
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
		switch (rand.nextInt(3)) {
		case 0: return Direction.BAS;
		case 1: return Direction.BASDROITE;
		case 2: return Direction.DROITE;
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
				System.out.println("humanCorner");
				checkingDirection(humanCorner());
			}
			else if (currentCase.getY()==Rules.worldMap_maxY-1) {
				System.out.println("elveCorner");
				checkingDirection(elveCorner());
			}
			else {
				System.out.println("northLimit");
				checkingDirection(northLimit());
			}
		}
		else if (currentCase.getX()==Rules.worldMap_maxX-1) {
			if (currentCase.getY()==0) {
				System.out.println("orcCorner");
				checkingDirection(orcCorner());
			}
			else if (currentCase.getY()==Rules.worldMap_maxY-1) {
				System.out.println("goblinCorner");
				checkingDirection(goblinCorner());
			}
			else {
				System.out.println("southLimit");
				checkingDirection(southLimit());
			}
		}
		else {
			if (currentCase.getY()==0) {
				System.out.println("westLimit");
				checkingDirection(westLimit());
			}
			else if (currentCase.getY()==Rules.worldMap_maxX-1) {
				System.out.println("eastLimit");
				checkingDirection(eastLimit());
			}
			else {
				System.out.println("center");
				checkingDirection(center());
			}
		}
	}
	
	public void checkingDirection(Direction direction) {
		System.out.println(direction);
		switch (direction) {
		case HAUT:
			System.out.println("HAUT");
			if(WorldMapService.getMap().checkingCase(currentCase.getX()-1,currentCase.getY())) {
				if (WorldMapService.getMap().getCase(currentCase.getX()-1, currentCase.getY()).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()).getEntity(),WorldMapService.getMap().getCase(currentCase.getX()-1, currentCase.getY()).getEntity(),currentCase.getX()-1, currentCase.getY());
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX()-1,currentCase.getY());
			}
			break;
		case HAUTGAUCHE:
			System.out.println("HAUTGAUCHE");
			if(WorldMapService.getMap().checkingCase(currentCase.getX()-1,currentCase.getY()-1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()-1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()).getEntity(),WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()-1).getEntity(),currentCase.getX()-1,currentCase.getY()-1);
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX()-1,currentCase.getY()-1);
			}
			break;
		case GAUCHE:
			System.out.println("GAUCHE");
			if(WorldMapService.getMap().checkingCase(currentCase.getX(),currentCase.getY()-1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX(),currentCase.getY()-1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()).getEntity(),WorldMapService.getMap().getCase(currentCase.getX(),currentCase.getY()-1).getEntity(),currentCase.getX(),currentCase.getY()-1);
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX(),currentCase.getY()-1);
			}
			break;
		case BASGAUCHE:
			System.out.println("BASGAUCHE");
			if(WorldMapService.getMap().checkingCase(currentCase.getX()+1,currentCase.getY()-1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()-1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()).getEntity(),WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()-1).getEntity(),currentCase.getX()+1,currentCase.getY()-1);
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX()+1,currentCase.getY()-1);
			}
			break;
		case BAS:
			System.out.println("BAS");
			if(WorldMapService.getMap().checkingCase(currentCase.getX()+1,currentCase.getY())) {
				if (WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()).getEntity(),WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()).getEntity(),currentCase.getX()+1,currentCase.getY());
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX()+1,currentCase.getY());
			}
			break;
		case BASDROITE:
			System.out.println("BASDROITE");
			if(WorldMapService.getMap().checkingCase(currentCase.getX()+1,currentCase.getY()+1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()+1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()).getEntity(),WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()+1).getEntity(),currentCase.getX()+1,currentCase.getY()+1);
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX()+1,currentCase.getY()+1);
			}
			break;
		case DROITE:
			System.out.println("DROITE");
			if(WorldMapService.getMap().checkingCase(currentCase.getX(),currentCase.getY()+1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX(),currentCase.getY()+1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()).getEntity(),WorldMapService.getMap().getCase(currentCase.getX(),currentCase.getY()+1).getEntity(),currentCase.getX(),currentCase.getY()+1);
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX(),currentCase.getY()+1);
			}
			break;
		case HAUTDROITE:
			System.out.println("HAUTDROITE");
			if(WorldMapService.getMap().checkingCase(currentCase.getX()-1,currentCase.getY()+1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()+1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()).getEntity(),WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()+1).getEntity(),currentCase.getX()-1,currentCase.getY()+1);
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX()-1,currentCase.getY()+1);
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
							if((WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.ORC && defense.getClass().getSimpleName() != "Orc") || (WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.GOBLIN && defense.getClass().getSimpleName() != "Gobelin")  ){
								fight(attack,defense);
							}						
						}
						break;
				}break;

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
							if((WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.ORC && defense.getClass().getSimpleName() != "Orc") || (WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.GOBLIN && defense.getClass().getSimpleName() != "Gobelin")  ){
								fight(attack,defense);
							}						
						}
						break;
				}break;
				

			case "Orc":
				switch (defense.getClass().getSimpleName()){
					case "Gobelin":
						helpSameAlliance(attack,defense);						
						break;
					case "Orc":
						helpSameRace(attack,defense);
						break;
					default:
						if(WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.ORC){
							if((WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.ELVE && defense.getClass().getSimpleName() != "Elfe") || (WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.HUMAN && defense.getClass().getSimpleName() != "Humain")  ){
								fight(attack,defense);
							}						
						}
						break;
				}break;

			case "Gobelin":
				switch (defense.getClass().getSimpleName()){
					case "Orc":
						helpSameAlliance(attack,defense);
						break;
					case "Gobelin":
						helpSameRace(attack,defense);
						break;
					default:
						if(WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.GOBLIN){
							if((WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.ELVE && defense.getClass().getSimpleName() != "Elfe") || (WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.HUMAN && defense.getClass().getSimpleName() != "Humain")  ){
								fight(attack,defense);
							}						
						}
						break;
				}break;

		}
	}
	public void helpSameRace(Entity attack,Entity defense){
		System.out.println("helpRace");
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
		System.out.println("HelpAlliance");
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
            if(defense.getPV() > 0){
            	defense.attack(attack);
            }

        }
        if(attack.getPV() <= 0 ){
        	System.out.println("death ===============================");
            WorldMapService.getMap().death(attack);
            defense.setXP(defense.getXP() + attack.getXP());
            WorldMapService.getMap().setNbEntities(WorldMapService.getMap().getNbEntities()-1);;
        }
        else{
        	System.out.println("death +++++++++++++++++++++++++++++++++");
            WorldMapService.getMap().death(defense);
            defense.setXP(defense.getXP() + attack.getXP());
            WorldMapService.getMap().setNbEntities(WorldMapService.getMap().getNbEntities()-1);;
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
