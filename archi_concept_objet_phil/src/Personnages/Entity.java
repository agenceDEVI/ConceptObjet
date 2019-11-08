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
		System.out.println("rnfjkegn");
		if(currentCase.getX()==0) {
			if (currentCase.getY()==0) {
				System.out.println("je veux");
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
		System.out.println("je vais");
		switch (direction) {
		case HAUT:
			System.out.println("testHaut");
			if(WorldMapService.getMap().checkingCase(currentCase.getX(),currentCase.getY()-1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()-1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(), currentCase.getY()-1).getEntity(),currentCase.getX(), currentCase.getY()-1);
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX(),currentCase.getY()-1);
			}
			break;
		case HAUTGAUCHE:
			System.out.println("TestHG");
			if(WorldMapService.getMap().checkingCase(currentCase.getX()-1,currentCase.getY()-1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()-1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()-1).getEntity(),currentCase.getX()-1,currentCase.getY()-1);
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX()-1,currentCase.getY()-1);
			}
			break;
		case GAUCHE:
			System.out.println("TestG");
			if(WorldMapService.getMap().checkingCase(currentCase.getX()-1,currentCase.getY())) {
				if (WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()).getEntity(),currentCase.getX()-1,currentCase.getY());
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX()-1,currentCase.getY());
			}
			break;
		case BASGAUCHE:
			System.out.println("BG");
			if(WorldMapService.getMap().checkingCase(currentCase.getX()-1,currentCase.getY()+1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()+1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX()-1,currentCase.getY()+1).getEntity(),currentCase.getX()-1,currentCase.getY()+1);
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX()-1,currentCase.getY()+1);
			}
			break;
		case BAS:
			System.out.println("B");
			if(WorldMapService.getMap().checkingCase(currentCase.getX(),currentCase.getY()+1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX(),currentCase.getY()+1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX(),currentCase.getY()+1).getEntity(),currentCase.getX(),currentCase.getY()+1);
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX(),currentCase.getY()+1);
			}
			break;
		case BASDROITE:
			System.out.println("BD");
			if(WorldMapService.getMap().checkingCase(currentCase.getX()+1,currentCase.getY()+1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()+1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()+1).getEntity(),currentCase.getX()+1,currentCase.getY()+1);
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX()+1,currentCase.getY()+1);
			}
			break;
		case DROITE:
			System.out.println("D");
			if(WorldMapService.getMap().checkingCase(currentCase.getX()+1,currentCase.getY())) {
				if (WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()).getEntity(),currentCase.getX()+1,currentCase.getY());
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX()+1,currentCase.getY());
			}
			break;
		case HAUTDROITE:
			System.out.println("HD");
			if(WorldMapService.getMap().checkingCase(currentCase.getX()+1,currentCase.getY()-1)) {
				if (WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()-1).getEntity()!=null) {
					rencontre(WorldMapService.getMap().getCase(currentCase.getX()+1,currentCase.getY()-1).getEntity(),currentCase.getX()+1,currentCase.getY()-1);
				}
				else WorldMapService.getMap().move(currentCase.getX(),currentCase.getY(),currentCase.getX()+1,currentCase.getY()-1);
			}
			break;
		default:
			System.out.println("!!!!!BUG!!!!!!");
		}
	}
	

	
	public void rencontre(Entity entity,int x, int y){
		switch (getClass().getSimpleName()) {
			case "Humain":
				System.out.println("Humain gvfgbg");
				switch (entity.getClass().getSimpleName()){
					case "Humain":
						System.out.println("testezt");
						helpSameRace(entity);
						System.out.println("tesoijforegn");
						break;
					case "Elfe":
						helpSameAlliance(entity);
						break;
					default:
						System.out.println("default");
						if(WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.HUMAN){
							fight(entity);
						}
						else{
							if(!(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.ORC && entity.getClass().getSimpleName() == "Orc") && !(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.GOBLIN && entity.getClass().getSimpleName() == "Gobelin")  ){
								fight(entity);
							}						
						}
						break;
				}

			case "Elfe":
				System.out.println("elfe gvfgbg");
				switch (entity.getClass().getSimpleName()){
					case "Humain":
						System.out.println("testezt");
						helpSameAlliance(entity);
						
						System.out.println("tesoijforegn");
						break;
					case "Elfe":
						helpSameRace(entity);
						break;
					default:
						System.out.println("default");
						if(WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.ELVE){
							fight(entity);
						}
						else{
							if(!(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.ORC && entity.getClass().getSimpleName() == "Orc") && !(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.GOBLIN && entity.getClass().getSimpleName() == "Gobelin")  ){
								fight(entity);
							}						
						}
						break;
				}
				

			case "Orc":
				System.out.println("Orc gvfgbg");
				switch (entity.getClass().getSimpleName()){
					case "Orc":
						helpSameAlliance(entity);						
						break;
					case "Gobelin":
						helpSameRace(entity);
						break;
					default:
						if(WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.ORC){
							fight(entity);
						}
						else{
							if(!(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.ELVE && entity.getClass().getSimpleName() == "Elfe") && !(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.HUMAN && entity.getClass().getSimpleName() == "Humain")  ){
								fight(entity);
							}						
						}
						break;
				}

			case "Gobelin":
				System.out.println("Gobelin gvfgbg");
				switch (entity.getClass().getSimpleName()){
					case "Gobelin":
						helpSameAlliance(entity);
						break;
					case "Orc":
						helpSameRace(entity);
						break;
					default:
						if(WorldMapService.getMap().getCase(x,y).getCaseType() != CaseType.GOBLIN){
							fight(entity);
						}
						else{
							if(!(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.ELVE && entity.getClass().getSimpleName() == "Elfe") && !(WorldMapService.getMap().getCase(x,y).getCaseType() == CaseType.HUMAN && entity.getClass().getSimpleName() == "Humain")  ){
								fight(entity);
							}						
						}
						break;
				}
				


		}
	}
	public void helpSameRace(Entity entity){
		System.out.println("HelpSAME RACEN froegneo ");
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
            this.attack(entity);
            entity.attack(this);

        }
        if(this.getPV() <= 0 ){
            WorldMapService.getMap().death(this);
            entity.setXP(entity.getXP() + this.getXP());
        }
        else{
            WorldMapService.getMap().death(entity);
            entity.setXP(entity.getXP() + this.getXP());
        }
    }
	
	public abstract void attack(Entity entitie);
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}

}
