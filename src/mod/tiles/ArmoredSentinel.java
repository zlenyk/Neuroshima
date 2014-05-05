package mod.tiles;

import java.util.LinkedList;


public class ArmoredSentinel extends Unit{
	ArmoredSentinel(int rotation){
		this.rotation = rotation;
		hp=1;
		shield = new boolean[6];
		for(int i=1; i<6; i++)	shield[i] = false;
		shield[0+rotation] = true
		isNetted = false;
		initiative = new LinkedList<Integer>();
		initiative.add(2);
		shootBonus = 0;
		hitBonus = 0;
	}
	public void attack(){
		shoot(1+rotation,1+shootBonus);
		shoot(5+rotation,1+shootBonus);
	}
	
	
}
