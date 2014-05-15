package mod.tiles.Borgo;

import java.awt.Image;
import java.util.LinkedList;

import mod.Unit;

import cont.board.ImageLoader;

public class SuperMutant extends Unit {
	SuperMutant(mod.FieldModel[] board){
		this.board = board;
		position = -1;
		//this.rotation = rotation;
		hp=2;
		shield = new boolean[6];
		for(int i=0;i<6;i++) shield[i] = false;
		shield[0]=true;
		shield[1]=true;
		shield[5]=true;
		isNetted = 0;
		initiative = new LinkedList<Integer>();
		initiative.add(2);
		shootBonus = 0;
		hitBonus = 0;
		initiativeBonus = 0;
	}

	public void attack(){
		hit(0+rotation, 2+hitBonus);
		hit(5+rotation, 1+hitBonus);
		hit(1+rotation, 1+hitBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Borgo.supermutant();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Borgo.supermutantSelected();
	}
	
}
