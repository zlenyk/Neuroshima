package mod.tiles;

import java.util.LinkedList;


public class Cyborg extends Unit{
	Cyborg(int rotation){
		this.rotation = rotation;
		hp=1;
		shield = new boolean[6];
		for(int i=0;i<6;i++) shield[i] = false;
		isNetted = false;
		initiative = new LinkedList<Integer>();
		initiative.add(3);
		shootBonus = 0;
		hitBonus = 0;
		
	}
	
	public void attack(){
		shoot(rotation,1+shootBonus);
	}
		
}
