package Personnages;

import archi_concept_objet_phil.Case;
import archi_concept_objet_phil.Rules;

public class Orc extends Entity {

	private static int nbOrc;
	
	public Orc(Case currentCase) {
		this.PV = Rules.orc_PV_Max;
		this.PE = Rules.orc_PE_Max;
		this.XP = 0;
		super.race = "Orc";
		this.currentCase=currentCase;


		nbOrc++;
	}
	
	@Override
	public void initPV_PE() {
		// TODO Auto-generated method stub

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
		return " 👹 ";
	}

	@Override
	public void attack(Entity entity){
        System.out.println("Met un coup avec sa hache");
        int damage = this.XP+1;
        entity.setPV(entity.getPV() - damage);
        System.out.println(entity.getPV());
    }

	/**
	 * @return the nbOrc
	 */
	public static int getNbOrc() {
		return nbOrc;
	}

	/**
	 * @param nbOrc the nbOrc to set
	 */
	public static void setNbOrc(int nbOrc) {
		Orc.nbOrc = nbOrc;
	}

}
