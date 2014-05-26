package mod.tiles.Moloch;

import gui.Field;

import java.awt.Image;

import cont.board.ImageLoader;

import java.util.LinkedList;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import mod.tiles.empty.Empty;

public class DzialkoGaussa extends Unit {
	DzialkoGaussa(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		position = -1;
		this.board = board;
		hp = 2;
		shield = new boolean[6];
		for(int i=0; i<6; i++)	shield[i] = false;
		netted = 0;
		initiative = new LinkedList<Integer>();
		initiative.add(1);
		shootBonus = 0;
		hitBonus = 0;
		initiativeBonus = 0;
	}
	
	public void attack(){
		//shoot(rotation,1+shootBonus);
		int direction = rotation, power = 1;
		while(board[position].neighbours[direction]!=null){
			if(!(board[position].neighbours[direction].getTile() instanceof Empty) 
					&& board[position].neighbours[direction].getTile().getOwner()!=this.owner){
				
				if(board[position].neighbours[direction].getTile().shield[(direction+3)%6]==false) 
					board[position].neighbours[direction].getTile().hp-=power;
				else board[position].neighbours[direction].getTile().hp-=(power-1);
				
			}
		}
	}
	// Dzialo Gaussa strzela do wszystkich celow na swojej linii

	@Override
	public Image getImage() {
		return ImageLoader.Moloch.dzialkogaussa();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.dzialkogaussaSelected();
	}
}
