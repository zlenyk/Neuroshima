package mod.tiles.Borgo;

import gui.Field;

import java.awt.Image;
import java.util.LinkedList;

import cont.board.ImageLoader;
import mod.FieldModel;
import mod.Player;
import mod.Tile;
import mod.tiles.empty.Empty;

public class Granat extends Tile {
	public Granat(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		this.board = board;
		
	}
	@Override
	public LinkedList<Integer> pick(){
		position = owner.getSztab().position;
		LinkedList<Integer> whereCanPut = new LinkedList<Integer>();
		for(int i=0;i<6;i++){
			if(board[position].neighbours[i]!=null && !(board[position].neighbours[i].tile instanceof Empty) && !board[position].neighbours[i].tile.isSztab()){
				whereCanPut.add(board[position].neighbours[i].position);
			}
		}
		return whereCanPut;
	}
	@Override
	public void put(int position, int rotation){
		board[position].tile.takeDmg(10);
	}

	@Override
	public Image getImage() {
		return ImageLoader.Borgo.granat();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Borgo.granatSelected();
	}

}
