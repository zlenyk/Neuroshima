package mod.tiles.Moloch;

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
	@Override
	public LinkedList<Integer> pick(){
		LinkedList<Integer> whereCanPut = new LinkedList<Integer>();
		for(int i=0;i<21;i++){
			if(i!=1 && i!=19){
				if(!(board[i].getTile() instanceof Empty) && board[i].getTile().getOwner()==this.owner && !board[i].getTile().isNetted()) whereCanPut.add(board[i].getPosition());
			}
			
		}
		return whereCanPut;
	}
	@Override
	public void put(int position, int rotation){
		mod.Tile tileToMove = board[position].getTile();
		LinkedList<Integer> whereCanPut = board[position].getTile().pick();
		//tileToMove.put(cont.game.GameController.choosePosition(whereCanPut),rotation);
		
	}
	@Override
	public Image getImage() {
		return ImageLoader.Moloch.ruch();
	}
	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.ruchSelected();
	}
}
