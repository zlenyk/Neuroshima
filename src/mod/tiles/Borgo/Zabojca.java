package mod.tiles.Borgo;

import java.awt.Image;
import java.util.LinkedList;

import mod.Unit;

import cont.board.ImageLoader;

public class Zabojca extends Unit {
	Zabojca(mod.FieldModel[] board){
		this.board = board;
		position = -1;
		//this.rotation = rotation;
		hp=1;
		shield = new boolean[6];
		for(int i=0;i<6;i++) shield[i] = false;
		isNetted = 0;
		initiative = new LinkedList<Integer>();
		initiative.add(3);
		shootBonus = 0;
		hitBonus = 0;
		initiativeBonus = 0;
	}

	public void attack(){
		shoot(0+rotation,1+shootBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Borgo.zabojca();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Borgo.zabojcaSelected();
	}
	
}
