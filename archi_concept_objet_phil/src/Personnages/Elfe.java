package Personnages;

import archi_concept_objet_phil.Case;
import archi_concept_objet_phil.Rules;

public class Elfe extends Entity {

	private static int nbElfe;
	
	public Elfe(Case currentCase) {
		this.PV = Rules.elfe_PV_Max;
		this.PE = Rules.elfe_PE_Max;
		this.XP = 0;
		super.race = "Elfe";
		this.currentCase=currentCase;

		nbElfe++;
	}
	
	@Override
	public void initPV_PE() {
		// TODO Auto-generated method stub

	}

	@Override
	public void attaque(Entity ennemi) {
		ennemi.PV = ennemi.PV - 3;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " 🧝 ";
	}

	@Override
	public void attack(Entity entity){
        System.out.println("Touche sa cible avec sa flèche");
        int damage = this.XP+1;
        entity.setPV(entity.getPV() - damage);
        System.out.println(entity.getPV());
    }

	/**
	 * @return the nbElfe
	 */
	public static int getNbElfe() {
		return nbElfe;
	}

	/**
	 * @param nbElfe the nbElfe to set
	 */
	public static void setNbElfe(int nbElfe) {
		Elfe.nbElfe = nbElfe;
	}

}
