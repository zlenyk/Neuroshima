package mod.tiles;

import java.util.LinkedList;



public class Blocker extends Unit {
	Blocker(int rotation){
		this.rotation = rotation;
		hp=2;
		shield = new boolean[6];
		for(int i=0;i<6;i++) shield[i] = false;
		shield[0+rotation] = true;
		isNetted = false;
		initiative = new LinkedList<Integer>();
	}
	
}
