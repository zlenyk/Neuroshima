package mod.tiles.Moloch;

import gui.Field;

import java.awt.Image;

import cont.board.ImageLoader;

import java.util.LinkedList;

import mod.FieldModel;
import mod.Player;
import mod.Unit;

public class Obronca extends Unit {
	Obronca(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		position = -1;
		this.board = board;
		hp = 2;
		shield = new boolean[6];
		for(int i=0; i<6; i++)	shield[i] = false;
		netted = 0;
		initiative = new LinkedList<Integer>();
		initiative.add(1);
		shootBonus = 0;
		hitBonus = 0;
		initiativeBonus = 0;
	}
	
	public void attack(){
		shoot(0+rotation, 1+shootBonus);
		shoot(1+rotation, 1+shootBonus);
		shoot(5+rotation, 1+shootBonus);
	}

	@Override
	public Image getImage() {
		return ImageLoader.Moloch.obronca();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.obroncaSelected();
	}
}
