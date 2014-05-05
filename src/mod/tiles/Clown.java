package mod.tiles;

import java.util.LinkedList;

public class Clown extends Unit {
	Clown(int rotation){
		this.rotation = rotation;
		hp = 2;
		shield = new boolean[6];
		for(int i=0; i<6; i++)	shield[i] = false;
		isNetted = false;
		initiative = new LinkedList<Integer>();
		initiative.add(2);
		shootBonus = 0;
		hitBonus = 0;
	}
	
	public void attack(){
		hit(0+rotation, 1+hitBonus);
		hit(5+rotation, 1+hitBonus);
	}
}
