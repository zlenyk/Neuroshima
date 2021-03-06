package mod.tiles.Hegemonia;

import gui.Field;

import java.awt.Image;

import cont.board.ImageLoader;
import mod.FieldModel;
import mod.Modul;
import mod.Player;
import mod.Unit;

public class Zwiadowca extends Modul {
	public Zwiadowca(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage(),getNettedImage());
		this.owner = owner;
		this.board = board;
		hp = 1;
		netted = 0;
		position = -1;
		working = false;
		ifWorks = new boolean[6];
		for(int i=5;i!=2;i=(i+1)%6){
			 ifWorks[i] = true;
		}
		for(int i=2;i<5;i++){
			 ifWorks[i] = false;
		}
		shield = new boolean[6];
		for(int i=0;i<6;i++) shield[i] = false;
	}
	
	public void work(int direction){
		if(isNetted())return;
		if(ifWorks[(6+direction-rotation)%6]==true){
			if(board[position].neighbours[direction].getTile() instanceof Unit && board[position].neighbours[direction].getTile().getOwner()==owner){
				((Unit)board[position].neighbours[direction].getTile()).initiativeBonus++;
			}
		}
	}
	
	public void stopWork(){
		if(isNetted())return;
		for(int i=5;i!=2;i=(i+1)%6){
			if(isGoodNeighbour(i) && board[position].neighbours[(i+rotation)%6].getTile() instanceof Unit && board[position].neighbours[(i+rotation)%6].getTile().getOwner()==owner){
				((Unit)board[position].neighbours[(i+rotation)%6].getTile()).initiativeBonus--;
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
		for(int i = 0; i<6; i++){
			if(isGoodNeighbour((i+rotation)%6)){
				work((i+rotation)%6); 
			}
		}
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Hegemonia.zwiadowca();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Hegemonia.zwiadowcaSelected();
	}
	
	@Override
	public Image getNettedImage() {
		return ImageLoader.Hegemonia.zwiadowcaNetted();
	}
}
