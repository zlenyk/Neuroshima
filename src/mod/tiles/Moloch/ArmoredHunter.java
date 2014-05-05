package mod.tiles.Moloch;

import java.util.LinkedList;

import mod.Unit;

public class ArmoredHunter extends Unit {
	ArmoredHunter(int rotation){
		this.rotation = rotation;
		hp = 1;
		shield = new boolean[6];
		for(int i=1; i<5; i++)	shield[i] = false;
		shield[0] = true;
		shield[5] = true;
		isNetted = 0;
		initiative = new LinkedList<Integer>();
		initiative.add(2);
		shootBonus = 0;
		hitBonus = 0;
		initiativeBonus = 0;
	}
	
	public void attack(){
		hit(0, 1+hitBonus);
		hit(1, 1+hitBonus);
		hit(2, 1+hitBonus);
		hit(3, 1+hitBonus);
		hit(4, 1+hitBonus);
		hit(5, 1+hitBonus);
	}
}
