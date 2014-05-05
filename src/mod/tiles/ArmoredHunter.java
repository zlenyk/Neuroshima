package mod.tiles;

import java.util.LinkedList;

public class ArmoredHunter extends Unit {
	ArmoredHunter(int rotation){
		this.rotation = rotation;
		hp = 1;
		shield = new boolean[6];
		for(int i=0; i<6; i++)	shield[i] = false;
			shield[0+rotation] = true;
			shield[5+rotation] = true;
		isNetted = false;
		initiative = new LinkedList<Integer>();
		initiative.add(2);
		shootBonus = 0;
		hitBonus = 0;
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
