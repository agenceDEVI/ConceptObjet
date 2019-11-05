package Personnages;

import archi_concept_objet_phil.WorldMapService;

public abstract class Entity {
	
	protected int PE;
	protected int PV;
	protected int XP;
	
	protected int nbrPopulationAlliance;
	protected static boolean alliance;
	
	public abstract void initPV_PE();
	public abstract void attaque(Entity ennemi);
	
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
        
        
        
        
}
