package mod.tiles.Moloch;

import java.util.LinkedList;

import mod.Unit;



public class Blocker extends Unit {
	Blocker(int rotation){
		this.rotation = rotation;
		hp=2;
		shield = new boolean[6];
		for(int i=0;i<6;i++) shield[i] = false;
		shield[0] = true;
		isNetted = 0;
		initiative = new LinkedList<Integer>();
	}
	
}
