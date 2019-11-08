package Personnages;

import archi_concept_objet_phil.Case;
import archi_concept_objet_phil.Rules;

public class Humain extends Entity {

	private static int nbHumain;

	public Humain(Case currentCase) {
		this.PV = Rules.humain_PV_Max;
		this.PE = Rules.humain_PE_Max;
		this.XP = 0;
		this.currentCase=currentCase;
		nbHumain++;
	}
	@Override
	public void initPV_PE() { 
		
	}

	@Override
	public void attaque(Entity ennemi) {
		ennemi.PV = ennemi.PV - 4;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " H";
	}
	@Override
	public void attack(Entity entity){
        System.out.println("Met un coup d’épée");
        int damage = this.XP;
        entity.setPV(entity.getPV() - damage);
    }
	/**
	 * @return the nbHumain
	 */
	public static int getNbHumain() {
		return nbHumain;
	}
	/**
	 * @param nbHumain the nbHumain to set
	 */
	public static void setNbHumain(int nbHumain) {
		Humain.nbHumain = nbHumain;
	}
	
	
	
}
