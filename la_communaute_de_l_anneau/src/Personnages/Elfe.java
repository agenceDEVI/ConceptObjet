package Personnages;

import other.Case;
import other.Rules;

public class Elfe extends Entity {

	private static int nbElfe;
	
	public Elfe(Case currentCase) {
		this.PV = Rules.elfe_PV_Max;
		this.PE = Rules.elfe_PE_Max;
		this.XP = Rules.elfe_XP_Start;
		super.race = "Elfe";
		this.currentCase=currentCase;

		nbElfe++;
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
