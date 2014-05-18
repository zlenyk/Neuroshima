package mod.tiles.Moloch;

import gui.Field;

import java.awt.Image;

import cont.board.ImageLoader;

import java.util.LinkedList;

import mod.FieldModel;
import mod.Player;
import mod.Unit;

public class OpancerzonyLowca extends Unit {
	OpancerzonyLowca(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		position = -1;
		this.board = board;
		hp = 1;
		shield = new boolean[6];
		for(int i=1; i<5; i++)	shield[i] = false;
		shield[0] = true;
		shield[5] = true;
		isNetted = 0;
		initiative = new LinkedList<Integer>();
		initiative.add(2);
		shootBonus = 0;
		hitBonus = 0;
		initiativeBonus = 0;
	}
	
	public void attack(){
		hit(0, 1+hitBonus);
		hit(1, 1+hitBonus);
		hit(2, 1+hitBonus);
		hit(3, 1+hitBonus);
		hit(4, 1+hitBonus);
		hit(5, 1+hitBonus);
	}

	@Override
	public Image getImage() {
		return ImageLoader.Moloch.opancerzonylowca();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.opancerzonylowcaSelected();
	}
}
