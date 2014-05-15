package mod.tiles.Moloch;

import java.awt.Image;

import cont.board.ImageLoader;

import java.util.LinkedList;

import mod.Unit;


public class Szturmowiec extends Unit {
	Szturmowiec(mod.FieldModel board[]){
		this.board = board;
		position = -1;
		//this.rotation = rotation;
		hp=2;
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
		shoot(rotation,1+shootBonus);
	}

	@Override
	public Image getImage() {
		return ImageLoader.Moloch.szturmowiec();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.szturmowiecSelected();
	}
}
