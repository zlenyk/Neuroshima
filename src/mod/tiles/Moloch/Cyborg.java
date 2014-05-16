package mod.tiles.Moloch;

import gui.Field;

import java.awt.Image;
import java.util.LinkedList;

import mod.Unit;
import cont.board.ImageLoader;

public class Cyborg extends Unit{
	Cyborg(){
		field = new Field(getImage(),getSelectedImage());

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
		shoot(rotation,1+shootBonus);
	}

	@Override
	public Image getImage() {
		return ImageLoader.Moloch.cyborg();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.cyborgSelected();
	}
		
}
