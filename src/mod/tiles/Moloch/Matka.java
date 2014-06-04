package mod.tiles.Moloch;

import gui.Field;

import java.awt.Image;

import cont.board.ImageLoader;
import mod.FieldModel;
import mod.Modul;
import mod.Player;
import mod.Unit;

public class Matka extends Modul {
	public Matka(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		this.board = board;
		hp = 1;
		netted = 0;
		position = -1;
		working = false;
		ifWorks = new boolean[6];
		ifWorks[0] = true;
		for(int i=1;i<6;i++){
			ifWorks[i] = false;
		}
		shield = new boolean[6];
		for(int i=0;i<6;i++) shield[i] = false;
	}
	
	public void work(int direction){
		if(isNetted())return;
		if(ifWorks[(6+direction-rotation)%6]==true){
			if(board[position].neighbours[direction].getTile() instanceof Unit && board[position].neighbours[direction].getTile().getOwner()==owner)
				((Unit)board[position].neighbours[direction].getTile()).changeInitiative(true); 
		}
	}
	
	public void stopWork(){
		if(isNetted())return;
		for(int i = 0; i<1; i++){
			if(isGoodNeighbour((i+rotation)%6) && board[position].neighbours[(i+rotation)%6].getTile() instanceof Unit && board[position].neighbours[(i+rotation)%6].getTile().getOwner()==owner){
				((Unit)board[position].neighbours[i].getTile()).changeInitiative(false);
			}
		}
	}
	
	@Override
	public void put(int position, int rotation){
		working = true;
		this.rotation = rotation;
		this.position=position;
		for(int i = 0; i<6; i++){
			if(isGoodNeighbour(i)){
				board[position].neighbours[i].getTile().work((i+3)%6);
			}
		}
		for(int i = 0; i<1; i++){
			if(isGoodNeighbour((i+rotation)%6)){
				work((i+rotation)%6); 
			}
		}
	}
	
	
	@Override
	public Image getImage() {
		return ImageLoader.Moloch.matka();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.matkaSelected();
	}
}
