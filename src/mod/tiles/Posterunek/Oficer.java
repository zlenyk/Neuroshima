package mod.tiles.Posterunek;

import gui.Field;

import java.awt.Image;

import cont.board.ImageLoader;
import mod.FieldModel;
import mod.Modul;
import mod.Player;
import mod.Unit;

public class Oficer extends Modul{
	public Oficer(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		this.board = board;
		hp = 1;
		netted = 0;
		position = -1;
		ifWorks = new boolean[6];
		for(int i=0;i<6;i++){
			ifWorks[i] = true;
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
		for(int i = 0; i<6; i++){
			if(isGoodNeighbour(i) && board[position].neighbours[(i+rotation)%6].getTile() instanceof Unit && board[position].neighbours[(i+rotation)%6].getTile().getOwner()==owner){
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
		for(int i = 0; i<6; i++){
			if(isGoodNeighbour((i+rotation)%6)){
				work((i+rotation)%6); 
			}
		}
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Posterunek.oficer();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Posterunek.oficerSelected();
	}
	
}
