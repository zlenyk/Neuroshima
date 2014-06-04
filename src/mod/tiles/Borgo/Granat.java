package mod.tiles.Borgo;

import gui.Field;

import java.awt.Image;
import java.util.LinkedList;

import mod.FieldModel;
import mod.Player;
import mod.Tile;
import cont.board.ImageLoader;

public class Granat extends Tile {
	public Granat(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage(), getNettedImage());
		this.owner = owner;
		this.board = board;
		
	}
	@Override
	public LinkedList<Integer> pick(){
		position = owner.getSztab().position;
		LinkedList<Integer> whereCanPut = new LinkedList<Integer>();
		for(int i=0;i<6;i++){
			if(isGoodNeighbour(i) && !board[position].neighbours[i].getTile().isSztab()){
				whereCanPut.add(board[position].neighbours[i].getPosition());
			}
		}
		return whereCanPut;
	}
	@Override
	public void put(int position, int rotation){
		board[position].getTile().takeDmg(10);
		if(board[position].getTile().getHp()<=0) board[position].getTile().die();
	}

	@Override
	public Image getImage() {
		return ImageLoader.Borgo.granat();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Borgo.granatSelected();
	}
	
	@Override
	public Image getNettedImage() {
		return ImageLoader.Borgo.granat();
	}

}
