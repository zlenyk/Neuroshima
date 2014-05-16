package mod.tiles.Hegemonia;

import gui.Field;

import java.awt.Image;
import java.util.LinkedList;

import mod.Unit;
import cont.board.ImageLoader;

public class Gladiator extends Unit {
	Gladiator(){
		field = new Field(getImage(),getSelectedImage());
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
		initiative.add(1);
		shootBonus = 0;
		hitBonus = 0;
		initiativeBonus = 0;
	}

	public void attack(){
		hit(0+rotation,2+hitBonus);
		hit(1+rotation,2+hitBonus);
		hit(5+rotation,2+hitBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Hegemonia.gladiator();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Hegemonia.gladiatorSelected();
	}
	
}
