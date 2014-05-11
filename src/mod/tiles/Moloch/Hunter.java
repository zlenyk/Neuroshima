package mod.tiles.Moloch;

import java.util.LinkedList;

import mod.Unit;

public class Hunter extends Unit {
	Hunter(int rotation){
		this.rotation = rotation;
		hp = 1;
		shield = new boolean[6];
		for(int i=0; i<6; i++)	shield[i] = false;
		isNetted = 0;
		initiative = new LinkedList<Integer>();
		initiative.add(3);
		shootBonus = 0;
		hitBonus = 0;
		initiativeBonus = 0;
	}
	
	public void attack(){
		hit(0+rotation, 1+hitBonus);
		hit(1+rotation, 1+hitBonus);
		hit(3+rotation, 1+hitBonus);
		hit(5+rotation, 1+hitBonus);
	}
}