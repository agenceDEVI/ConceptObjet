package world;


import elements.Neutre;
import elements.safe_zone.*;

public class WorldMap {

	//private ArrayList<ArrayList<Case>> worldMap;
	private Case[][]worldMap;
	
	private int size_x = 20;
	private int size_y = 20;
	
	private int size_safezone = 5;
	
	public void initMap() {
		/*this.worldMap = new ArrayList<ArrayList<Case>>();
		
		ArrayList<Case> ligne = new ArrayList<Case>();
		ligne.add(new Case(0,0,1));
		ligne.add(new Case(0,1,1));
		ligne.add(new Case(0,2,2));
		worldMap.add(ligne);
		this.displayWorldMap();
		
		System.out.println();
		//ligne.clear();
		//ArrayList<Case> ligne1 = new ArrayList<Case>();
		this.displayWorldMap();
		
		System.out.println();
		ligne.add(new Case(1,0,0));
		ligne.add(new Case(1,1,1));
		ligne.add(new Case(1,2,5));
		worldMap.add(ligne);
		
		
		this.displayWorldMap();*/
		this.worldMap = new Case[size_x][size_y];
		
		for (int y = 0; y < size_y; y++) {
			for (int x = 0; x < size_x; x++) {
				
				if(y<size_safezone && x<size_safezone) {
					worldMap[y][x]=new Case(y,x,new SafeZoneHumain());
				}
				else if (y<size_safezone && x>(size_x-(1+size_safezone))) {
					worldMap[y][x]=new Case(y,x,new SafeZoneElfe());
				}
				else if (y>(size_y-(1+size_safezone)) && x<size_safezone) {
					worldMap[y][x]=new Case(y,x,new SafeZoneGobelin());
				}
				else if (y>(size_y-(1+size_safezone)) && x>(size_x-(1+size_safezone))) {
					worldMap[y][x]=new Case(y,x,new SafeZoneOrc());
				}
				
				else {
					worldMap[y][x]=new Case(y,x,new Neutre());
				}
				
				
			}
			
		}
		
		this.displayWorldMap();
		
	}
	
	public void displayWorldMap() {
		/*for (ArrayList<Case> arrayListLigne : this.worldMap) {
			for (Case case1 : arrayListLigne) {
				case1.displayCase();
			}
			System.out.println();
		}*/
		System.out.println("test");
		for (Case[] cases : worldMap) {
			for (Case case1 : cases) {
				case1.displayCase();
			}
			System.out.println();
		}
	}
}
