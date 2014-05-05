package mod.tiles.Moloch;

import java.util.LinkedList;

import mod.Unit;

public class GaussCannon extends Unit {
	GaussCannon(int rotation){
		this.rotation = rotation;
		hp = 2;
		shield = new boolean[6];
		for(int i=0; i<6; i++)	shield[i] = false;
		isNetted = 0;
		initiative = new LinkedList<Integer>();
		initiative.add(1);
		shootBonus = 0;
		hitBonus = 0;
		initiativeBonus = 0;
	}
	
	public void attack(){
		shoot(rotation,1+shootBonus);
	}
	// Dzialo Gaussa strzela do wszystkich celow na swojej linii
}
