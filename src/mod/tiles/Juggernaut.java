package mod.tiles;

import java.util.LinkedList;


public class Juggernaut extends Unit{
	Juggernaut(int rotation){
		this.rotation = rotation;
		hp=2;
		shield = new boolean[6];
		for(int i=0;i<6;i++){
			if(i%2==1)shield[i] = false;
			else shield[i] = true;
		}
		isNetted = false;
		initiative = new LinkedList<Integer>();
		initiative.add(1);
		shootBonus = 0;
		hitBonus = 0;
	}
	public void attack(){
		shoot(1+rotation,1+shootBonus);
		hit(0+rotation,2+hitBonus);
	}
	
	
}
