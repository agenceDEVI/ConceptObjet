package Personnages;

import other.Case;
import other.Rules;

public class Orc extends Entity {

	private static int nbOrc;
	
	public Orc(Case currentCase) {
		this.PV = Rules.orc_PV_Max;
		this.PE = Rules.orc_PE_Max;
		this.XP = Rules.orc_XP_Start;
		super.race = "Orc";
		this.currentCase=currentCase;


		nbOrc++;
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
