package Personnages;

import archi_concept_objet_phil.Rules;

public class Elfe extends Entity {

	private static int nbElfe;
	
	public Elfe() {
		this.PV = Rules.elfe_PV_Max;
		this.PE = Rules.elfe_PE_Max;
		this.XP = 0;
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
		return " E";
	}

}
