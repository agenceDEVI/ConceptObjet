package Personnages;

import other.Case;
import other.Rules;

public class Gobelin extends Entity {

	private static int nbGoblelin;
	
	public Gobelin(Case currentCase) {
		this.PV = Rules.gobelin_PV_Max;
		this.PE = Rules.gobelin_PE_Max;
		this.XP = Rules.gobelin_XP_Start;
		super.race = "Gobelin";
		this.currentCase=currentCase;

		nbGoblelin++;
	}

	/**
	 * @return the nbGoblelin
	 */
	public static int getNbGoblelin() {
		return nbGoblelin;
	}
	
	/**
	 * @param nbGoblelin the nbGoblelin to set
	 */
	public static void setNbGoblelin(int nbGoblelin) {
		Gobelin.nbGoblelin = nbGoblelin;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " 😈 ";
	}

	@Override
	public void attack(Entity entity){
        System.out.println("Met un coup de lance");
        int damage = this.XP+1;
        entity.setPV(entity.getPV() - damage);
        System.out.println(entity.getPV());
    }

}
