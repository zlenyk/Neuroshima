package mod.tiles.Moloch;

import gui.Field;

import java.awt.Image;

import cont.board.ImageLoader;

import java.util.LinkedList;

import mod.FieldModel;
import mod.Player;
import mod.Unit;

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
		/*while(board[position].neibours[direction]!=null){
			if(board[position].neibours[direction].tile!=null){
				if(board[position].neibours[direction].tile.shield[(direction+3)%6]==false) 
					board[position].neibours[direction].tile.hp-=power;
				else board[position].neibours[direction].tile.hp-=(power-1);
				
			}
		}*/
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
