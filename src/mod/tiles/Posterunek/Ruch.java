package mod.tiles.Posterunek;

import gui.Field;

import java.awt.Image;

import cont.board.ImageLoader;

import java.util.LinkedList;

import mod.Player;
import mod.tiles.empty.Empty;

public class Ruch extends mod.Tile {
	
	public Ruch(Player owner){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
	}
	public LinkedList<Integer> pick(){
		LinkedList<Integer> whereCanPut = new LinkedList<Integer>();
		for(int i=0;i<21;i++){
			if(i!=1 && i!=19){
				if(board[i]!=null && !(board[position].neighbours[0].tile instanceof Empty) && board[i].tile.owner==this.owner) whereCanPut.add(board[position].neighbours[i].position);
			}
			
		}
		return whereCanPut;
	}
	public void put(int position, int rotation){
		mod.Tile tileToMove = board[position].tile;
		LinkedList<Integer> whereCanPut = board[position].tile.pick();
		tileToMove.put(cont.game.GameController.choosePosition(whereCanPut),rotation);
		
	}
	@Override
	public Image getImage() {
		return ImageLoader.Posterunek.ruch();
	}
	@Override
	public Image getSelectedImage() {
		return ImageLoader.Posterunek.ruchSelected();
	}
}
