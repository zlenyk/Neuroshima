package mod.tiles.Moloch;

import java.awt.Image;
import java.util.LinkedList;

import mod.Unit;

public class Webb extends Unit {
	Webb(mod.FieldModel[] board){
		this.board = board;
		position = -1;
		//this.rotation = rotation;
		hp = 1;
		shield = new boolean[6];
		for(int i=0; i<6; i++)	shield[i] = false;
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
	
	// Ma siec w kierunkach 0 i 5
}
