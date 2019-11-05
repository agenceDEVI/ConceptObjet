package Personnages;

import archi_concept_objet_phil.Rules;

public class Humain extends Entity {

	private static int nbHumain;

	public Humain() {
		this.PV = Rules.humain_PV_Max;
		this.PE = Rules.humain_PE_Max;
		this.XP = 0;
		nbHumain++;
	}
	@Override
	public void initPV_PE() { 
		
	}

	@Override
	public void attaque(Entity ennemi) {
		ennemi.PV = ennemi.PV - 4;
	}
	
	
	
}
