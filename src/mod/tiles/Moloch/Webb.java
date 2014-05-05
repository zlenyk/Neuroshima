package mod.tiles.Moloch;

import java.util.LinkedList;

import mod.Unit;

public class Webb extends Unit {
	Webb(int rotation){
		this.rotation = rotation;
		hp = 1;
		shield = new boolean[6];
		for(int i=0; i<6; i++)	shield[i] = false;
		isNetted = 0;
		initiative = new LinkedList<Integer>();
	}
	
	// Ma siec w kierunkach 0 i 5
}
