package mod.tiles.Borgo;

import gui.Field;

import java.awt.Image;
import java.util.LinkedList;

import cont.board.ImageLoader;
import mod.FieldModel;
import mod.Player;
import mod.Tile;

public class Battle extends Tile {

	public Battle(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage(), getNettedImage());
		this.owner = owner;
		this.board = board;
		
	}
	@Override
	public LinkedList<Integer> pick(){
		LinkedList<Integer> whereCanPut = new LinkedList<Integer>();
		for(int i=0;i<21;i++) if(i!= 1 && i != 19) whereCanPut.add(i);
		return whereCanPut;
	}
	@Override
	public boolean isInstant(){
		return true;
	}
	@Override
	public boolean isBattle(){
		return true;
	}
	@Override
	public void put(int position, int rotation){ }

	@Override
	public Image getImage() {
		return ImageLoader.Borgo.bitwa();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Borgo.bitwaSelected();
	}
	
	@Override
	public Image getNettedImage(){
		return ImageLoader.Borgo.bitwa();
	}

}