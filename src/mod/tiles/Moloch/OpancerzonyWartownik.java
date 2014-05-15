package mod.tiles.Moloch;

import gui.Field;

import java.awt.Image;

import cont.board.ImageLoader;

import java.util.LinkedList;

import mod.Unit;


public class OpancerzonyWartownik extends Unit{
	OpancerzonyWartownik(mod.FieldModel[] board){
		field = new Field(getImage(),getSelectedImage());

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
		return ImageLoader.Moloch.opancerzonywartownik();
	}
	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.opancerzonywartownikSelected();
	}
	
	
}
