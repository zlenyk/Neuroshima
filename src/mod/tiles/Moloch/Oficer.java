package mod.tiles.Moloch;

import gui.Field;

import java.awt.Image;

import mod.FieldModel;
import mod.Modul;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;


public class Oficer extends Modul {
	public Oficer(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		this.board = board;
		position = -1;
		hp = 1;
		netted = 0;
		ifWorks = new boolean[6];
		for(int i=0;i<6;i++){
			if(i%2==0)ifWorks[i] = false;
			else ifWorks[i] = true;
		}
		shield = new boolean[6];
		for(int i=0;i<6;i++) shield[i] = false;
	}
	public void work(int direction){
		if(isNetted())return;
		if(ifWorks[(6+direction-rotation)%6]==true){
			if(board[position].neighbours[direction].getTile() instanceof Unit && board[position].neighbours[direction].getTile().getOwner()==owner){
				((Unit)board[position].neighbours[direction].getTile()).shootBonus++;
			}
		}
	}
	
	public void stopWork(){
		if(isNetted())return;
		for(int i = 0; i<6; i+=2){
			if(board[position].neighbours[(i+rotation)%6].getTile() instanceof Unit && board[position].neighbours[(i+rotation)%6].getTile().getOwner()==owner){
				((Unit)board[position].neighbours[(i+rotation)%6].getTile()).shootBonus--;
			}
		}
	}
	
	@Override
	public void put(int position, int rotation){
		this.rotation = rotation;
		this.position=position;
		for(int i = 0; i<6; i++){
			if(isGoodNeighbour(i)){
				board[position].neighbours[i].getTile().work((i+3)%6);
			}
		}
		for(int i = 1; i<6; i+=2){
			if(isGoodNeighbour(i+rotation)){
				work((i+rotation)%6); 
			}
		}	
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Moloch.oficer();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.oficerSelected();
	}
}
