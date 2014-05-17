package mod.tiles.Hegemonia;

import gui.Field;

import java.awt.Image;
import java.util.LinkedList;

import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class UniwersalnyZolnierz extends Unit {
	UniwersalnyZolnierz(Player owner){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		position = -1;
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
		hit(0+rotation,1+hitBonus);
		shoot(0+rotation,1+shootBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Hegemonia.uniwersalnyzolnierz();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Hegemonia.uniwersalnyzolnierzSelected();
	}
	
}
