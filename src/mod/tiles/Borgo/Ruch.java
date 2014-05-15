package mod.tiles.Borgo;

import gui.Field;

import java.awt.Image;
import java.util.LinkedList;

import cont.board.ImageLoader;

public class Ruch extends mod.Tile {
	
	public Ruch(){
		field = new Field(getImage(),getSelectedImage());
	}
	public LinkedList<Integer> pick(){
		LinkedList<Integer> whereCanPut = new LinkedList<Integer>();
		for(int i=0;i<21;i++) if(board[i]!=null&&board[i].tile!=null&&board[i].tile.owner==this.owner) whereCanPut.add(board[position].neibours[i].position);
		
		return whereCanPut;
	}
	public void put(int position, int rotation){
		mod.Tile tileToMove = board[position].tile;
		board[position].tile.pick();
		
		//choosePosition();
		
		tileToMove.put(position,rotation);
		
	}
	@Override
	public Image getImage() {
		return ImageLoader.Borgo.ruch();
	}
	@Override
	public Image getSelectedImage() {
		return ImageLoader.Borgo.ruchSelected();
	}
}
