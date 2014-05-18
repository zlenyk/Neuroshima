package mod;

import mod.tiles.Borgo.BorgoArmySet;
import mod.tiles.Borgo.SztabBorgo;
import mod.tiles.Hegemonia.HegemoniaArmySet;
import mod.tiles.Hegemonia.SztabHegemonia;
import mod.tiles.Moloch.MolochArmySet;
import mod.tiles.Moloch.SztabMoloch;
import mod.tiles.Posterunek.PosterunekArmySet;
import mod.tiles.Posterunek.SztabPosterunek;

public class Player {
	private final String name;
	private ArmySet armySet;
	private mod.Tile sztab;
	public Player(String n,String army, FieldModel board[]){
		name = n;
		if(army.equals("Borgo")){
			armySet = new BorgoArmySet(this, board);
			sztab = new SztabBorgo(this, board);
		}
		if(army.equals("Hegemonia")){
			armySet = new HegemoniaArmySet(this, board);
			sztab = new SztabHegemonia(this, board);
		}
		if(army.equals("Moloch")){
			armySet = new MolochArmySet(this, board);
			sztab = new SztabMoloch(this, board);
		}
		if(army.equals("Posterunek")){
			armySet = new PosterunekArmySet(this, board);
			sztab = new SztabPosterunek(this, board);
		}
	}
	public Tile getTile(){
		return armySet.getRandomTile();
	}
	public String getName(){
		return name;
	}
	public Tile getSztab(){
		return sztab;
	}
}
