package mod.tiles.Moloch;

import java.awt.Image;
import java.util.LinkedList;

import mod.Unit;


public class ArmoredSentinel extends Unit{
	ArmoredSentinel(mod.FieldModel[] board){
		this.board = board;
		position = -1;
		//this.rotation = rotation;
		hp=1;
		shield = new boolean[6];
		for(int i=1; i<6; i++)	shield[i] = false;
		shield[0] = true;
		isNetted = 0;
		initiative = new LinkedList<Integer>();
		initiative.add(2);
		shootBonus = 0;
		hitBonus = 0;
		initiativeBonus = 0;
	}
	public void attack(){
		shoot(1+rotation,1+shootBonus);
		shoot(5+rotation,1+shootBonus);
	}
	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Image getSelectedImage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
