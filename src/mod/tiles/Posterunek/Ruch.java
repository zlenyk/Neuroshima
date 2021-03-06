package mod.tiles.Posterunek;

import gui.Field;

import java.awt.Image;

import cont.board.ImageLoader;

import java.util.LinkedList;

import mod.FieldModel;
import mod.Player;
import mod.tiles.empty.Empty;

public class Ruch extends mod.Tile {
	
	public Ruch(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage(),getNettedImage());
		this.owner = owner;
		this.board = board;
	}
	public LinkedList<Integer> pick(){
		LinkedList<Integer> whereCanPut = new LinkedList<Integer>();
		for(int i=0;i<21;i++){
			if(i!=1 && i!=19){
				if(!(board[i].getTile() instanceof Empty) 
						&& board[i].getTile().getOwner()==this.owner 
						&& !board[i].getTile().isNetted()){
					
					whereCanPut.add(board[i].getPosition());
				}
			}
		}
		return whereCanPut;
	}
	public void put(int position, int rotation){}
	@Override
	public Image getImage() {
		return ImageLoader.Posterunek.ruch();
	}
	@Override
	public Image getSelectedImage() {
		return ImageLoader.Posterunek.ruchSelected();
	}
	
	@Override
	public Image getNettedImage() {
		return ImageLoader.Posterunek.ruch();
	}
}
