package mod.tiles.Posterunek;

import java.awt.Image;
import java.util.LinkedList;

import mod.Unit;

import cont.board.ImageLoader;

public class Ckm extends Unit {
	Ckm(mod.FieldModel[] board){
		this.board = board;
		position = -1;
		//this.rotation = rotation;
		hp=1;
		shield = new boolean[6];
		for(int i=0;i<6;i++) shield[i] = false;
		isNetted = 0;
		initiative = new LinkedList<Integer>();
		initiative.add(2);
		initiative.add(1);
		shootBonus = 0;
		hitBonus = 0;
		initiativeBonus = 0;
	}

	public void attack(){
		shoot(0+rotation,1+shootBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Posterunek.ckm();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Posterunek.ckmSelected();
	}
	
}
