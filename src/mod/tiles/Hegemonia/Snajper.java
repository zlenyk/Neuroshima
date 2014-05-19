package mod.tiles.Hegemonia;

import gui.Field;

import java.awt.Image;
import java.util.LinkedList;

import mod.FieldModel;
import mod.Player;
import mod.Tile;
import mod.tiles.empty.Empty;
import cont.board.ImageLoader;

public class Snajper extends Tile {
	public Snajper(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		this.board = board;
	}
	
	public LinkedList<Integer> pick(){
		LinkedList<Integer> whereCanPut = new LinkedList<Integer>();
		for(int i=0;i<21;i++){
			if(i!=1 && i!=19){
				if(board[i]!=null && !(board[position].neighbours[0].tile instanceof Empty) && board[i].tile.owner!=this.owner) whereCanPut.add(board[position].neighbours[i].position);
			}
		}
		return whereCanPut;
	}
	public void put(int position, int rotation){
		board[position].tile.takeDmg(1);
	}

	@Override
	public Image getImage() {
		return ImageLoader.Hegemonia.snajper();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Hegemonia.snajper();
	}
}