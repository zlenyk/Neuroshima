package mod.tiles.Moloch;

import java.awt.Image;
import java.util.LinkedList;

import mod.Unit;



public class Blocker extends Unit {
	Blocker(mod.FieldModel[] board){
		this.board = board;
		position = -1;
		//this.rotation = rotation;
		hp=2;
		shield = new boolean[6];
		for(int i=0;i<6;i++) shield[i] = false;
		shield[0] = true;
		isNetted = 0;
		initiative = new LinkedList<Integer>();
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
