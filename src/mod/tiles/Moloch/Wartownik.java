package mod.tiles.Moloch;

import gui.Field;

import java.awt.Image;

import cont.board.ImageLoader;

import java.util.LinkedList;

import mod.Player;
import mod.Unit;

public class Wartownik extends Unit {
	Wartownik(Player owner){
		field = new Field(getImage(),getSelectedImage());

		position = -1;
		this.owner = owner;
		hp = 1;
		shield = new boolean[6];
		for(int i=0; i<6; i++)	shield[i] = false;
		isNetted = 0;
		initiative = new LinkedList<Integer>();
		initiative.add(2);
		shootBonus = 0;
		hitBonus = 0;
		initiativeBonus = 0;
	}
	
	public void attack(){
		shoot(0+rotation, 1+shootBonus);
		shoot(5+rotation, 1+shootBonus);
	}

	@Override
	public Image getImage() {
		return ImageLoader.Moloch.wartownik();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.wartownikSelected();
	}
}
