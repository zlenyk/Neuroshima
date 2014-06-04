package mod.tiles.Posterunek;

import gui.Field;

import java.awt.Image;

import cont.board.ImageLoader;
import mod.FieldModel;
import mod.Modul;
import mod.Player;

public class CentrumRozpoznania extends Modul {
	public CentrumRozpoznania(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		this.board = board;
		hp = 1;
		netted = 0;
		position = -1;
		working = false;
		ifWorks = new boolean[6];
		for(int i=0;i<6;i++){
			ifWorks[i] = false;
		}
		shield = new boolean[6];
		for(int i=0;i<6;i++) shield[i] = false;
	}
	
	
	
	
	public void stopWork(){ }
	
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
	}
	
	
	@Override
	public Image getImage() {
		return ImageLoader.Posterunek.centrumrozpoznawania();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Posterunek.centrumrozpoznawaniaSelected();
	}
}
