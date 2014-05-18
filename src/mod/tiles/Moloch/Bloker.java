package mod.tiles.Moloch;

import gui.Field;

import java.awt.Image;
import java.util.LinkedList;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class Bloker extends Unit {
	Bloker(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		position = -1;
		this.board = board;
		hp=2;
		shield = new boolean[6];
		for(int i=0;i<6;i++) shield[i] = false;
		shield[0] = true;
		isNetted = 0;
		initiative = new LinkedList<Integer>();
	}

	@Override
	public Image getImage() {
		return ImageLoader.Moloch.bloker();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.blokerSelected();
	}
	
}
