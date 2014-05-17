package mod.tiles.Moloch;

import gui.Field;

import java.awt.Image;

import cont.board.ImageLoader;

import java.util.LinkedList;

import mod.Player;
import mod.Unit;

public class Sieciarz extends Unit {
	Sieciarz(Player owner){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		position = -1;
		hp = 1;
		shield = new boolean[6];
		for(int i=0; i<6; i++)	shield[i] = false;
		isNetted = 0;
		initiative = new LinkedList<Integer>();
	}

	@Override
	public Image getImage() {
		return ImageLoader.Moloch.sieciarz();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.sieciarzSelected();
	}
	
	// Ma siec w kierunkach 0 i 5
}
