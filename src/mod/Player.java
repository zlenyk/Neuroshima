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
	private Tile sztab;
	private int sztabPosition;
	private String army;
	public Player(String n,String army, FieldModel board[]){
		sztabPosition = -1;
		name = n;
		if(army.equals("Borgo")){
			armySet = new BorgoArmySet(this, board);
			this.army = "Borgo";
			sztab = new SztabBorgo(this, board);
		}
		if(army.equals("Hegemonia")){
			armySet = new HegemoniaArmySet(this, board);
			this.army = "Hegemonia";
			sztab = new SztabHegemonia(this, board);
		}
		if(army.equals("Moloch")){
			armySet = new MolochArmySet(this, board);
			this.army = "Moloch";
			sztab = new SztabMoloch(this, board);
		}
		if(army.equals("Posterunek")){
			armySet = new PosterunekArmySet(this, board);
			this.army = "Posterunek";
			sztab = new SztabPosterunek(this, board);
		}
	}
	public void setSztabPosition(int p){
		sztabPosition = p;
	}
	public int getSztabPosition(){
		return sztabPosition;
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
	public String getArmy(){
		return army;
	}
	public ArmySet getArmySet(){
		return armySet;
	}
}
