package mod.tiles.Moloch;

import gui.Field;

import java.awt.Image;

import mod.FieldModel;
import mod.Modul;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;


public class Zwiadowca extends Modul {
	public Zwiadowca(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		this.board = board;
		hp = 1;
		netted = 0;
		position = -1;
		ifWorks = new boolean[6];
		for(int i=0;i<6;i++){
			if(i%2==1)ifWorks[i] = false;
			else ifWorks[i] = true;
		}
		
	}
	
	public void work(int direction){
		if(ifWorks[(direction+rotation)%6]==true){
			if(board[position].neighbours[(direction+rotation)%6].getTile() instanceof Unit){
				((Unit)board[position].neighbours[(direction+rotation)%6].getTile()).initiativeBonus++;
			}
		}
	}
	
	public void stopWork(){
		for(int i = 0; i<6; i+=2){
			if(isGoodNeighbour(i) && board[position].neighbours[(i+rotation)%6].getTile() instanceof Unit){
				((Unit)board[position].neighbours[(i+rotation)%6].getTile()).initiativeBonus--;
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
		for(int i = 0; i<6; i+=2){
			if(isGoodNeighbour((i+rotation)%6)){
				work((i+rotation)%6); 
			}
		}
	}
	
	
	@Override
	public Image getImage() {
		return ImageLoader.Moloch.zwiadowca();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.zwiadowcaSelected();
	}
	
}