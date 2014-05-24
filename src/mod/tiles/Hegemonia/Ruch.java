package mod.tiles.Hegemonia;

import gui.Field;

import java.awt.Image;

import cont.board.ImageLoader;

import java.util.LinkedList;

import mod.FieldModel;
import mod.Player;
import mod.tiles.empty.Empty;

public class Ruch extends mod.Tile {
	
	public Ruch(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		this.board = board;
	}
	public LinkedList<Integer> pick(){
		LinkedList<Integer> whereCanPut = new LinkedList<Integer>();

		for(int i=0;i<21;i++){
			if(i!=1 && i!=19){
				if(!(board[i].tile instanceof Empty) && board[i].tile.getOwner()==this.owner && !board[i].tile.isNetted()) whereCanPut.add(board[i].position);
			}
			
		}
		return whereCanPut;
	}
	public void put(int position, int rotation){
		mod.Tile tileToMove = board[position].tile;
		LinkedList<Integer> whereCanPut = board[position].tile.pick();
		//tileToMove.put(cont.game.GameController.choosePosition(whereCanPut),rotation);
		
	}
	@Override
	public Image getImage() {
		return ImageLoader.Hegemonia.ruch();
	}
	@Override
	public Image getSelectedImage() {
		return ImageLoader.Hegemonia.ruchSelected();
	}
}
