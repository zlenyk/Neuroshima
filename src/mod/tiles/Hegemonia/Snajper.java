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
		field = new Field(getImage(),getSelectedImage(),getNettedImage());
		this.owner = owner;
		this.board = board;
	}
	
	public LinkedList<Integer> pick(){
		LinkedList<Integer> whereCanPut = new LinkedList<Integer>();
		for(int i=0;i<21;i++){
			if(i!=1 && i!=19){
				if(!(board[i].getTile() instanceof Empty) 
						&& !board[i].getTile().isSztab() 
						&& board[i].getTile().getOwner()!=this.owner){
					
					whereCanPut.add(board[i].getPosition());
				}
			}
		}
		return whereCanPut;
	}
	public void put(int position, int rotation){
		board[position].getTile().takeDmg(1);
		if(board[position].getTile().getHp()<=0) board[position].getTile().die();
	}

	@Override
	public Image getImage() {
		return ImageLoader.Hegemonia.snajper();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Hegemonia.snajperSelected();
	}
	
	@Override
	public Image getNettedImage() {
		return ImageLoader.Hegemonia.snajper();
	}
}
