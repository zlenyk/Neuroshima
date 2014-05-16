package mod;

import mod.tiles.Borgo.BorgoArmySet;
import mod.tiles.Hegemonia.HegemoniaArmySet;
import mod.tiles.Moloch.MolochArmySet;
import mod.tiles.Posterunek.PosterunekArmySet;

public class Player {
	private final String name;
	private ArmySet armySet;
	public Player(String n,String army){
		name = n;
		if(army.equals("Borgo")){
			armySet = new BorgoArmySet();
		}
		if(army.equals("Hegemonia")){
			armySet = new HegemoniaArmySet();
		}
		if(army.equals("Moloch")){
			armySet = new MolochArmySet();
		}
		if(army.equals("Posterunek")){
			armySet = new PosterunekArmySet();
		}
	}
	public Tile getTile(){
		return armySet.getRandomTile();
	}
	public String getName(){
		return name;
	}
}
