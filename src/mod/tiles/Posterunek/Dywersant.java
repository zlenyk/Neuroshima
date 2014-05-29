package mod.tiles.Posterunek;

import java.awt.Image;

import cont.board.ImageLoader;
import gui.Field;
import mod.FieldModel;
import mod.Modul;
import mod.Player;
import mod.Unit;

public class Dywersant extends Modul {
	public Dywersant(Player owner, FieldModel board[]){
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
		
	}
	
	public void work(int direction){
		if(ifWorks[(6+direction-rotation)%6]==true){
			if(board[position].neighbours[direction].getTile() instanceof Unit && board[position].neighbours[direction].getTile().getOwner()!=owner){
				((Unit)board[position].neighbours[direction].getTile()).initiativeBonus--;
			}
		}
	}
	
	public void stopWork(){
		for(int i = 0; i<6; i++){
			if(isGoodNeighbour(i) && board[position].neighbours[(i+rotation)%6].getTile() instanceof Unit && board[position].neighbours[(i+rotation)%6].getTile().getOwner()!=owner){
				((Unit)board[position].neighbours[(i+rotation)%6].getTile()).initiativeBonus++;
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
		return ImageLoader.Posterunek.dywersant();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Posterunek.dywersantSelected();
	}
}
