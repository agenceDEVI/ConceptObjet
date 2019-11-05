package Personnages;

import archi_concept_objet_phil.Rules;

public class Gobelin extends Entity {

	private static int nbGoblelin;
	
	public Gobelin() {
		this.PV = Rules.gobelin_PV_Max;
		this.PE = Rules.gobelin_PE_Max;
		this.XP = 0;
	}
	
	@Override
	public void initPV_PE() {
		// TODO Auto-generated method stub

	}

	@Override
	public void attaque(Entity ennemi) {
		ennemi.PV = ennemi.PV - 2;
	}

}
