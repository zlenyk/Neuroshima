package mod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArmySet {
	protected List<Tile> list;
	private Random randomGenerator;
	public ArmySet(){
		randomGenerator = new Random();
		list = new ArrayList<Tile>();
	}
	public Tile getRandomTile(){
		int index = randomGenerator.nextInt(list.size());
		Tile t = list.get(index);
		list.remove(t);
		return t;
	}
	public int getSize(){
		return list.size();
	}
}
